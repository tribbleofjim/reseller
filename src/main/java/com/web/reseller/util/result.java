package com.web.reseller.util;
import java.util.List;
public class result {
    private static final int SUCCESS = 200;
    private static final int FAILED = 500;
    private int code;

    private int num;
    private String message;
    private Object data;
    public static result No_product = new result(500,0,"no product",null);
    public static result No_reseller = new result(500,0,"no reseller",null);
    public static result No_operator = new result(500,0,"no operator",null);
    public static result No_order = new result(500, 0, "no order", null);
    public static result No_percentage = new result(500, 0, "no percentage", null);

    public result(int code,int num, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.num = num;
    }  public static int getSUCCESS() {
        return SUCCESS;
    }

    public static int getFAILED() {
        return FAILED;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }   public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }}

