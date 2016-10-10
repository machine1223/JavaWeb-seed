package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.util.DataTableSlice;
import com.eliteams.quick4j.core.util.DateUtil;
import com.eliteams.quick4j.web.dao.CartMapper;
import com.eliteams.quick4j.web.dao.ProductMapper;
import com.eliteams.quick4j.web.model.Cart;
import com.eliteams.quick4j.web.model.Product;
import com.eliteams.quick4j.web.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 11:50
 */
@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Resource
    private ProductMapper productMapper;

    @Override
    public void saveCartInfo(Cart cart) {
        Product product = productMapper.getProDetailById(cart.getProId());
        cart.setName(product.getName());
        cart.setPrice(product.getPrice());
        cart.setTotal(cart.getPrice() * cart.getBuyCount());
        cart.setCreateTime(new Date());
        cartMapper.saveCartInfo(cart);
    }

    @Override
    public DataTableSlice<Cart> getCartSlice(long userId) {
        List<Cart> cartList = cartMapper.getCartSliceByUserId(userId);
        for (Cart cart : cartList){
            String time = DateUtil.dateToStringStr(cart.getCreateTime());
            cart.setTime(time);
        }
        return new DataTableSlice<Cart>(cartList.size(), cartList);
    }

    @Override
    public void deleteByUserId(long userId) {
        cartMapper.deleteByUserId(userId);
    }
}
