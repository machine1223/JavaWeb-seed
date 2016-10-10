package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.util.DataTableSlice;
import com.eliteams.quick4j.web.model.Order;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 19:19
 */
public interface OrderService {

    void saveOrderInfo(Order order);

    DataTableSlice<Order> getOrderSlice(long userId);
}
