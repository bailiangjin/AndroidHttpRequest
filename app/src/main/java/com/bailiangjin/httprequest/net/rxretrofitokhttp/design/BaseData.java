package com.bailiangjin.httprequest.net.rxretrofitokhttp.design;

/**
 * 数据返回的基类
 *
 * @author bailiangjin
 */
public class BaseData<T> {

    private int code = -1;

    private String msg;

    private int total;

    private T data;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
