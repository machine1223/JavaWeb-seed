package com.eliteams.quick4j.web.controller;

import com.eliteams.quick4j.core.entity.Const;
import com.eliteams.quick4j.core.entity.JSONResult;
import com.eliteams.quick4j.core.util.DataTableSlice;
import com.eliteams.quick4j.web.model.*;
import com.eliteams.quick4j.web.service.OrderService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * Created by robu
 * Date:2016/9/19
 * Time:17:56
 */
@RestController
@RequestMapping("/item")
public class ItemController{

    @Resource
    private OrderService orderService;

    /**
     * 保存购物车信息
     * @return
     */
    @RequestMapping(value = "/build", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult saveOrderInfo(@RequestBody Order order) {
        orderService.saveOrderInfo(order);
        return new JSONResult(Const.SUCCESS_CODE, null);
    }

    /**
     * 获取结算详情
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult<DataTableSlice<Order>> getProductDetail(@RequestParam("userId") long userId) {
        return new JSONResult<DataTableSlice<Order>>(orderService.getOrderSlice(userId));
    }


}
