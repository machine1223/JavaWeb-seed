package com.eliteams.quick4j.web.controller;

import com.eliteams.quick4j.web.model.Product;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by robu
 * Date:2016/9/19
 * Time:17:56
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 获取商品详情页（暂时只取10个）
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductList(@RequestParam("proType") int proType) {
        return productService.getProducts(proType);
    }

    /**
     * 获取商品详情页（暂时只取10个）
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductDetail(@RequestParam("id") long id) {
        return productService.getProductDetail(id);
    }
}
