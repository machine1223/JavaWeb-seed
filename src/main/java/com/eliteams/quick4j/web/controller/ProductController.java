package com.eliteams.quick4j.web.controller;

import com.eliteams.quick4j.web.model.Product;
import com.eliteams.quick4j.web.model.User;
import com.eliteams.quick4j.web.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
     * 获取商品详情页（暂时只取8个）
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductList() {
        return productService.getProducts();
    }
}
