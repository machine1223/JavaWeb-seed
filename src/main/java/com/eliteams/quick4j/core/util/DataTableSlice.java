package com.eliteams.quick4j.core.util;

import java.util.List;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 12:28
 */
public class DataTableSlice<T> {

    private String sEcho;
    private long iTotalRecords;
    private long iTotalDisplayRecords;
    private List<T> aaData;

    public DataTableSlice(long totalCount, List<T> content) {
        this.iTotalRecords = totalCount;
        this.iTotalDisplayRecords = totalCount;
        this.aaData = content;
    }

    public long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public List<T> getAaData() {
        return aaData;
    }

    public void setAaData(List<T> aaData) {
        this.aaData = aaData;
    }
}
