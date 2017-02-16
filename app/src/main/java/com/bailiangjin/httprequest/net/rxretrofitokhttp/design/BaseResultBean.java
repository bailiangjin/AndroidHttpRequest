package com.bailiangjin.httprequest.net.rxretrofitokhttp.design;

/**
 * 服务的返回数据基类
 * Created by bailiangjin on 16/5/13.
 */
public class BaseResultBean {

    /**
     * 成功
     */
    public static final int CODE_SUCCESS = 10000;

    /**
     * 请求参数异常
     */
    public static final int CODE_PARAM_ERROR = -10005;


    protected int code=-1;
    protected volatile String msg;

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
}
