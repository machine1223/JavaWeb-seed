package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 19:26
 */
public interface OrderMapper extends GenericDao<Order, Long> {

    void saveOrderInfo(Order order);

    List<Order> getOrderSlice(@Param("userId") long userId);
}
