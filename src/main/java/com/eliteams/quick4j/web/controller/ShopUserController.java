package com.eliteams.quick4j.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.eliteams.quick4j.core.entity.JSONResult;
import com.eliteams.quick4j.web.model.ShopUser;
import com.eliteams.quick4j.web.service.ShopUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.security.PermissionSign;
import com.eliteams.quick4j.web.security.RoleSign;
import com.eliteams.quick4j.web.service.UserService;

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
     * 用户登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult register(@RequestBody ShopUser user) {
        int num = shopUserService.saveShopUser(user);
        if(num > 0){
            return new JSONResult(0, user);
        }else{
            return new JSONResult(-1, user);
        }
    }
}
