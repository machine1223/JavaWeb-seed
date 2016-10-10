package com.eliteams.quick4j.web.service;

import com.eliteams.quick4j.core.util.DataTableSlice;
import com.eliteams.quick4j.web.model.Account;
import com.eliteams.quick4j.web.model.SelectArray;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 16:59
 */
public interface AccountService {

    void deleteByUserId(long userId);

    void saveAccount(long[] selectArray);

    void saveDirectAccount(SelectArray selectArray);

    DataTableSlice<Account> getAccountSlice(long userId);

    double getTotalPrice(long userId);
}
