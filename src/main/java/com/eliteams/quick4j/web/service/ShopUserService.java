package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.web.model.ShopUser;

/**
 * Created by wangxing
 * Date: 2016/9/21.
 * Time: 22:46
 */
public interface ShopUserService {

    Integer saveShopUser(ShopUser user);

    Integer validateUser(ShopUser user);

    Integer loginValidate(ShopUser user);

    ShopUser loginSystem(ShopUser user);

}
