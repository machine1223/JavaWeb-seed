package com.eliteams.quick4j.web.model;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 16:57
 */
public class SelectArray {

    private long[] selectArray;
    private long userId;
    private int buyCount;

    public long[] getSelectArray() {
        return selectArray;
    }

    public void setSelectArray(long[] selectArray) {
        this.selectArray = selectArray;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }
}
