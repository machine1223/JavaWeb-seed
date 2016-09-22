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
    public Integer saveShopUser(ShopUser user) {
        return shopUserMapper.saveShopUser(user);
    }

    @Override
    public Integer validateUser(ShopUser user) {
        return shopUserMapper.validateUser(user);
    }

    @Override
    public Integer loginValidate(ShopUser user) {
        return shopUserMapper.loginValidate(user);
    }

    @Override
    public ShopUser loginSystem(ShopUser user) {
        return shopUserMapper.loginSystem(user);
    }
}
