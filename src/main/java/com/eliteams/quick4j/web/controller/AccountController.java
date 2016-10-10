package com.eliteams.quick4j.web.controller;

import com.eliteams.quick4j.core.entity.Const;
import com.eliteams.quick4j.core.entity.JSONResult;
import com.eliteams.quick4j.core.util.DataTableSlice;
import com.eliteams.quick4j.web.model.Account;
import com.eliteams.quick4j.web.model.Cart;
import com.eliteams.quick4j.web.model.SelectArray;
import com.eliteams.quick4j.web.model.ShopUser;
import com.eliteams.quick4j.web.service.AccountService;
import com.eliteams.quick4j.web.service.CartService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * Created by robu
 * Date:2016/9/19
 * Time:17:56
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private CartService cartService;

    @Resource
    private AccountService accountService;

    /**
     * 保存购物车信息
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<Cart> saveCartInfo(@RequestBody Cart cart) {
        cartService.saveCartInfo(cart);
        return new JSONResult<Cart>(Const.SUCCESS_CODE, cart);
    }

    /**
     * 获取结算详情
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult<DataTableSlice<Account>> getProductDetail(@RequestParam("userId") long userId) {
        return new JSONResult<DataTableSlice<Account>>(accountService.getAccountSlice(userId));
    }

    /**
     * 获取商品详情页（暂时只取10个）
     * @return
     */
    @RequestMapping(value = "/sub", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<DataTableSlice<Cart>> getAccount(@RequestBody SelectArray selectArray) {
        accountService.deleteByUserId(selectArray.getUserId());
        accountService.saveAccount(selectArray.getSelectArray());
        return new JSONResult<DataTableSlice<Cart>>();
    }

    /**
     * 获取商品详情页（暂时只取10个）
     * @return
     */
    @RequestMapping(value = "/direct", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<DataTableSlice<Account>> directAccount(@RequestBody SelectArray selectArray) {
        accountService.deleteByUserId(selectArray.getUserId());
        accountService.saveDirectAccount(selectArray);
        return new JSONResult<DataTableSlice<Account>>();
    }

    /**
     * 获取结算详情
     * @return
     */
    @RequestMapping(value = "/total", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult getTotalAccount(@RequestParam("userId") long userId) {
        return new JSONResult(Const.SUCCESS_CODE, accountService.getTotalPrice(userId));
    }


}
