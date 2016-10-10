package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.Cart;
import com.eliteams.quick4j.web.model.Chat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 11:58
 */
public interface CartMapper extends GenericDao<Cart, Long> {

    void saveCartInfo(Cart cart);

    List<Cart> getCartSliceByUserId(@Param("userId") long userId);

    Cart getDetailById(@Param("id") long id);

    void deleteById(@Param("id") long id);

    void deleteByUserId(@Param("userId") long userId);

}
