package com.web.reseller.util;

public class message {
    private String msg;
    private int code;

    // 一些常见的请求状态码
    private static int SUCCESS_CODE = 200;
    private static int SUCCESS_CODE_1 = 201;
    private static int SUCCESS_CODE_2 = 202;
    private static int SUCCESS_CODE_3 = 203;
    private static int SUCCESS_CODE_4 = 204;
    private static int SUCCESS_CODE_5 = 205;

    private static int CLIENT_ERROR_CODE = 400;
    private static int SERVER_ERROR_CODE = 500;
    private static int NOT_FOUND_CODE = 404;
    private static int Info_ERROR_CODE=600;
    // 一些内置的返回message
    //注册模块
    public static message Wrong_age = new message("wrong age！",Info_ERROR_CODE);
    public static message Wrong_PhoneN = new message("wrong phone number！",Info_ERROR_CODE);
    public static message Wrong_QQNumber = new message("noQQnumber！",Info_ERROR_CODE);
    public static message Wrong_city = new message("noCity！",Info_ERROR_CODE);
    public static message Reg_Success = new message("register successfully!",SUCCESS_CODE);
    public static message Confirm_Password = new message("different password!",CLIENT_ERROR_CODE);
    // 登录模块
    public static message SUCCESS_5 = new message("class_5_success", SUCCESS_CODE_5);
    public static message SUCCESS_4 = new message("class_4_success", SUCCESS_CODE_4);
    public static message SUCCESS_3 = new message("class_3_success", SUCCESS_CODE_3);
    public static message SUCCESS_2 = new message("class_2_success", SUCCESS_CODE_2);
    public static message SUCCESS_1 = new message("class_1_success", SUCCESS_CODE_1);
    public static message SUCCESS = new message("success", SUCCESS_CODE);
    public static message No_ROLE = new message("no role,please choose a role",SERVER_ERROR_CODE);
    public static message NO_USER = new message("no user please register!", CLIENT_ERROR_CODE);
    public static message PASSWORD_ERROR = new message("wrong password!", CLIENT_ERROR_CODE);
    public static message No_Phonenumber = new message("please input a phonenumber ",Info_ERROR_CODE);
    public static message No_Password = new message("please input a password",Info_ERROR_CODE);
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
