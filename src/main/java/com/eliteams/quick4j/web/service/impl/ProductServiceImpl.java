package com.eliteams.quick4j.web.service.impl;

import com.eliteams.quick4j.web.dao.ProductMapper;
import com.eliteams.quick4j.web.model.Product;
import com.eliteams.quick4j.web.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by robu
 * Date:2016/9/19
 * Time:17:59
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> getProducts() {
        return productMapper.getAllPro();
    }
}
