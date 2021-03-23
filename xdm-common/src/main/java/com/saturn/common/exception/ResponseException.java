package com.saturn.common.exception;

/**
 * @Author: qyl
 * @Date: 2021/3/23 22:24
 * @Description: 响应异常类
 */
public class ResponseException extends RuntimeException {

    /**
     * 异常响应码
     */
    private int code;

    /**
     * 异常响应码
     */
    private String msg;

    public ResponseException(int code, String msg, String message) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
