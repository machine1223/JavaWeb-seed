package com.eliteams.quick4j.core.entity;


/**
 * JSONResult : Response JSONResult for RESTful,封装返回JSON格式的数据
 *
 * @author StarZou
 * @since 2014年5月26日 上午10:51:46
 */

public class JSONResult<T> extends Result {

    private static final long serialVersionUID = 7880907731807860636L;

    /**
     * 数据
     */
    private T data;

    /**
     * @author by wangxing 设置返回结果
     */
    private int code;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JSONResult() {
        super();
    }

    /**
     * 自定义返回的结果
     *
     * @param data
     * @param message
     * @param success
     */
    public JSONResult(T data, String message, boolean success) {
        this.data = data;
        super.setMessage(message);
        super.setSuccess(success);
    }

    /**
     * 成功返回数据和消息
     *
     * @param data
     * @param message
     */
    public JSONResult(T data, String message) {
        this.data = data;
        super.setMessage(message);
        super.setSuccess(true);
    }

    public JSONResult(int code, T data) {
        this.code = code;
        this.data = data;
        super.setSuccess(true);
    }

    /**
     * 返回给操作成功
     * @param code 操作返回码
     * @param message 返回信息
     */
    public JSONResult(int code, String message) {
        this.code = code;
        super.setMessage(message);
        super.setSuccess(true);
    }

    /**
     * 成功返回数据
     *
     * @param data
     */
    public JSONResult(T data) {
        this.data = data;
        super.setSuccess(true);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}