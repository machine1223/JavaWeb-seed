package com.eliteams.quick4j.web.model;

import java.util.Date;

/**
 * Created by wangxing
 * Date: 2016/10/6.
 * Time: 19:15
 */
public class Order {
    private long id;
    private String houseNum;
    private String phone;
    private String rangeA;
    private String rangeB;
    private long userId;
    private String orderNum;
    private String content;
    private Date createTime;
    private double total;
    private String payWay;

    private String time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRangeA() {
        return rangeA;
    }

    public void setRangeA(String rangeA) {
        this.rangeA = rangeA;
    }

    public String getRangeB() {
        return rangeB;
    }

    public void setRangeB(String rangeB) {
        this.rangeB = rangeB;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
