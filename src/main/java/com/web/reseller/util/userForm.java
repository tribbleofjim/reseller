package com.web.reseller.util;

import com.web.reseller.model.L2User;

import java.util.List;

public class userForm {
    private String code;
    private int msg;
    private int count;
    private List<L2User> data;

    public userForm(String code, int msg, int count, List<L2User> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<L2User> getData() {
        return data;
    }

    public void setData(List<L2User> data) {
        this.data = data;
    }
}
