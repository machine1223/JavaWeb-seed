package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.ShopUser;

/**
 * Created by wangxing
 * Date: 2016/9/21.
 * Time: 22:48
 */
public interface ShopUserMapper extends GenericDao<ShopUser, Long> {

    int saveShopUser(ShopUser user);
}
