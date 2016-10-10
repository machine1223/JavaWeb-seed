package com.eliteams.quick4j.web.dao;

import com.eliteams.quick4j.core.generic.GenericDao;
import com.eliteams.quick4j.web.model.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 17:02
 */
public interface AccountMapper extends GenericDao<Account, Long> {

    void deleteByUserId(@Param("userId") long userId);

    void saveAccount(Account account);

    List<Account> getAccountSlice(@Param("userId") long userId);
}
