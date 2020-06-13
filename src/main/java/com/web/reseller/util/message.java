package com.web.reseller.util;

public class message {
    private String msg;
    private int code;

    // 一些常见的请求状态码
    private static int SUCCESS_CODE = 200;
    private static int CLIENT_ERROR_CODE = 400;
    private static int SERVER_ERROR_CODE = 500;
    private static int NOT_FOUND_CODE = 404;

    // 一些内置的返回message
    // 登录模块
    public static message SUCCESS = new message("success", SUCCESS_CODE);
    public static message NO_USER = new message("没有这个用户，请注册", CLIENT_ERROR_CODE);
    public static message PASSWORD_ERROR = new message("密码错误", CLIENT_ERROR_CODE);

    public message(String msg){
        this.msg = msg;
    }

    public message(String msg, int code){
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
