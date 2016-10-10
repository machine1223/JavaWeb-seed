package com.eliteams.quick4j.web.controller;

import com.eliteams.quick4j.core.entity.Const;
import com.eliteams.quick4j.core.entity.JSONResult;
import com.eliteams.quick4j.core.util.DataTableSlice;
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
@RequestMapping("/cart")
public class CartController {

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
     * 获取商品详情页（暂时只取10个）
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult<DataTableSlice<Cart>> getProductDetail(@RequestParam("userId") long userId) {
        return new JSONResult<DataTableSlice<Cart>>(cartService.getCartSlice(userId));
    }

    /**
     * 删除之前结算，开始新的结算
     * @return
     */
    @RequestMapping(value = "/sub", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult getAccount(@RequestBody SelectArray selectArray) {
        accountService.deleteByUserId(selectArray.getUserId());
        accountService.saveAccount(selectArray.getSelectArray());
        return new JSONResult(Const.SUCCESS_CODE, null);
    }

    /**
     * 删除之前结算，开始新的结算
     * @return
     */
    @RequestMapping(value = "/clear", method = RequestMethod.DELETE)
    @ResponseBody
    public JSONResult clearCart(@RequestParam("userId") long userId) {
        cartService.deleteByUserId(userId);
        return new JSONResult(Const.SUCCESS_CODE, null);
    }
}
