package com.eliteams.quick4j.web.controller;

import javax.annotation.Resource;

import com.eliteams.quick4j.core.entity.Const;
import com.eliteams.quick4j.core.entity.JSONResult;
import com.eliteams.quick4j.web.model.ShopUser;
import com.eliteams.quick4j.web.service.ShopUserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 *
 * @author StarZou
 * @since 2014年5月28日 下午3:54:00
 **/
@RestController
@RequestMapping("/shopuser")
public class ShopUserController {

    @Resource
    private ShopUserService shopUserService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<ShopUser> register(@RequestBody ShopUser user) {
        if(StringUtils.isEmpty(user.getUserName())){
            return new JSONResult<ShopUser>(Const.FAILED_CODE, "起一个用户名吧");
        }
        if(StringUtils.isEmpty(user.getStudentNo())){
            return new JSONResult<ShopUser>(Const.FAILED_CODE, "学号不能为空哦");
        }
        if(StringUtils.isEmpty(user.getPassword())){
            return new JSONResult<ShopUser>(Const.FAILED_CODE, "您不想设置密码？");
        }
        if(StringUtils.isEmpty(user.getPhoneNo())){
            return new JSONResult<ShopUser>(Const.FAILED_CODE, "请把手机号告诉亲哦");
        }
        if(StringUtils.isEmpty(user.getSex())){
            return new JSONResult<ShopUser>(Const.FAILED_CODE, "不要忘记性别哦");
        }
        Integer userCount = shopUserService.validateUser(user);
        if(null == userCount || userCount == 0){
            Integer num = shopUserService.saveShopUser(user);
            if(null == num || num == 0){
                return new JSONResult<ShopUser>(Const.FAILED_CODE, user);//保存失败
            }else{
                return new JSONResult<ShopUser>(Const.SUCCESS_CODE, user);
            }
        }
        return new JSONResult<ShopUser>(Const.FAILED_CODE, "您填写的用户名或学号已经存在");
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<ShopUser> login(@RequestBody ShopUser user) {
        Integer userCount = shopUserService.loginValidate(user);
        if(null == userCount || userCount == 0){//用户名不存在
            return new JSONResult<ShopUser>(Const.USER_NOT_EXIST, "您的用户名不存在，赶快去注册哦");
        }
        ShopUser shopUser = shopUserService.loginSystem(user);
        if(null == shopUser){//密码错误
            return new JSONResult<ShopUser>(Const.PASSWORD_ERROR, "您的密码错误");
        }
        return new JSONResult<ShopUser>(Const.SUCCESS_CODE, "登录成功");
    }
}
