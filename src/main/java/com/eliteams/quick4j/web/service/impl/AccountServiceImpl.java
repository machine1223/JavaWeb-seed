package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.util.DataTableSlice;
import com.eliteams.quick4j.web.dao.AccountMapper;
import com.eliteams.quick4j.web.dao.CartMapper;
import com.eliteams.quick4j.web.dao.ProductMapper;
import com.eliteams.quick4j.web.model.Account;
import com.eliteams.quick4j.web.model.Cart;
import com.eliteams.quick4j.web.model.Product;
import com.eliteams.quick4j.web.model.SelectArray;
import com.eliteams.quick4j.web.service.AccountService;
import com.eliteams.quick4j.web.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 16:59
 */
@Service
public class AccountServiceImpl implements AccountService{

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private CartMapper cartMapper;

    @Resource
    private ProductMapper productMapper;

    @Override
    public void deleteByUserId(long userId) {
        accountMapper.deleteByUserId(userId);
    }

    @Override
    public void saveAccount(long[] selectArray) {
        for (long id : selectArray){
            Cart cart = cartMapper.getDetailById(id);//获取购物车中对应商品信息
            Account account = new Account();
            account.setName(cart.getName());
            account.setUserId(cart.getUserId());
            account.setPrice(cart.getPrice());
            account.setProId(cart.getProId());
            account.setTotal(cart.getTotal());
            account.setBuyCount(cart.getBuyCount());
            account.setCreateTime(cart.getCreateTime());
            accountMapper.saveAccount(account);
            cartMapper.deleteById(id);//结算某个商品后就将其在购物车中删除
        }
    }

    @Override
    public void saveDirectAccount(SelectArray selectArray) {
        for (long id : selectArray.getSelectArray()){
            Product product = productMapper.getProDetailById(id);//获取购物车中对应商品信息
            Account account = new Account();
            account.setName(product.getName());
            account.setUserId(selectArray.getUserId());
            account.setPrice(product.getPrice());
            account.setProId(id);
            account.setTotal(product.getPrice()* selectArray.getBuyCount());
            account.setBuyCount(selectArray.getBuyCount());
            account.setCreateTime(new Date());
            accountMapper.saveAccount(account);
        }
    }

    @Override
    public DataTableSlice<Account> getAccountSlice(long userId) {
        List<Account> accountList = accountMapper.getAccountSlice(userId);
        return new DataTableSlice<Account>(accountList.size(), accountList);
    }

    @Override
    public double getTotalPrice(long userId) {
        List<Account> accounts = accountMapper.getAccountSlice(userId);
        double totalPrice = 0;
        for (Account account : accounts){
            totalPrice += account.getTotal();
        }
        return totalPrice;
    }
}
