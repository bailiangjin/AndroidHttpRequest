package com.bailiangjin.httprequest.net.rxretrofitokhttp.design;

/**
 * 统一异常处理 通用异常
 * @author bailiangjin
 */
public class ApiException extends RuntimeException {

    public static final int USER_NOT_EXIST = 100;
    public static final int WRONG_PASSWORD = 101;
    public static final int TOKEN_INVALIDE = 400001;
    public static final int ILLEGAL_USER = 400000;

    private int code;

    public ApiException(int resultCode, String resultMessage) {
        this(getApiExceptionMessage(resultCode, resultMessage));
        this.code=resultCode;
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 处理服务器错误码：
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，再显示给用户
     */
    private static String getApiExceptionMessage(int code, String message) {
        switch (code) {
            case USER_NOT_EXIST:
                message = "该用户不存在";
                break;
            case WRONG_PASSWORD:
                message = "密码错误";
                break;
            default:
                break;

        }
        return message;
    }

    public int getCode() {
        return code;
    }
}

