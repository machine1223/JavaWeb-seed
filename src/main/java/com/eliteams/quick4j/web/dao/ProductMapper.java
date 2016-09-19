package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.Invite;
import com.eliteams.quick4j.web.model.Product;

import java.util.List;

/**
 * Created by robu
 * Date:2016/9/19
 * Time:18:05
 */
public interface ProductMapper extends GenericDao<Invite, Long> {

    List<Product> getAllPro();
}
