package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.core.util.DataTableSlice;
import com.eliteams.quick4j.core.util.DateUtil;
import com.eliteams.quick4j.web.dao.AccountMapper;
import com.eliteams.quick4j.web.dao.OrderMapper;
import com.eliteams.quick4j.web.model.Account;
import com.eliteams.quick4j.web.model.Order;
import com.eliteams.quick4j.web.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 19:24
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void saveOrderInfo(Order order) {
        List<Account> accountList = accountMapper.getAccountSlice(order.getUserId());
        StringBuilder stringBuilder = new StringBuilder();
        for (Account account : accountList){
            stringBuilder.append(account.getName()).append(":").append(account.getBuyCount()).append(";");
        }
        order.setContent(stringBuilder.toString());
        Random random = new Random();
        order.setOrderNum(DateUtil.dateToString(new Date()).replace("-", "") + String.format("%d", random.nextInt(89999) + 10000));
        order.setCreateTime(new Date());
        orderMapper.saveOrderInfo(order);
    }

    @Override
    public DataTableSlice<Order> getOrderSlice(long userId) {
        List<Order> orderList = orderMapper.getOrderSlice(userId);
        for (Order order : orderList){
            String time = DateUtil.dateToStringStr(order.getCreateTime());
            order.setTime(time);
        }
        return new DataTableSlice<Order>(orderList.size(), orderList);
    }
}
