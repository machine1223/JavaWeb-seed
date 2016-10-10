package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.util.DataTableSlice;
import com.eliteams.quick4j.web.model.Cart;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 11:50
 */
public interface CartService {

    void saveCartInfo(Cart cart);

    DataTableSlice<Cart> getCartSlice(long userId);

    void deleteByUserId(long userId);
}
