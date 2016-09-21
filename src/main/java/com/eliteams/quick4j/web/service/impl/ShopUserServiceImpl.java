package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.web.dao.ShopUserMapper;
import com.eliteams.quick4j.web.model.ShopUser;
import com.eliteams.quick4j.web.service.ShopUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by wangxing
 * Date: 2016/9/21.
 * Time: 22:47
 */
@Service
@Transactional
public class ShopUserServiceImpl implements ShopUserService {

    @Resource
    private ShopUserMapper shopUserMapper;

    @Override
    public int saveShopUser(ShopUser user) {
        return shopUserMapper.saveShopUser(user);
    }
}
