package com.xll.util;

/**
 * 一个统一返回的类，封装了返回给前端页面的信息
 * @author lonely.xia
 * @date 2017/10/17
 */
public class GeneralResponse<T> {

    /** 返回给页面的数据 */
    T data;

    /** 返回操作执行的结果 */
    String msg;

    /** 返回执行的状态码，操作执行成功一律返回200 */
    int code;

    public GeneralResponse(String msg , int code) {
        this.msg = msg;
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}
