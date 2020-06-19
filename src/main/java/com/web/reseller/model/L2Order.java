package com.web.reseller.model;

import java.math.BigDecimal;
import java.util.Date;

public class L2Order {
    private String orderid;

    private String buyername;

    private String buyerphone;

    private String tourid;

    private double tourprice;

    private String role1;

    private String role2;

    private String role3;

    private String role4;

    private String role5;

    private Date createtime;

    private Date finishtime;

    private Integer orderstatus;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername == null ? null : buyername.trim();
    }

    public String getBuyerphone() {
        return buyerphone;
    }

    public void setBuyerphone(String buyerphone) {
        this.buyerphone = buyerphone == null ? null : buyerphone.trim();
    }

    public String getTourid() {
        return tourid;
    }

    public void setTourid(String tourid) {
        this.tourid = tourid == null ? null : tourid.trim();
    }

    public double getTourprice() {
        return tourprice;
    }

    public void setTourprice(double tourprice) {
        this.tourprice = tourprice;
    }

    public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1 == null ? null : role1.trim();
    }

    public String getRole2() {
        return role2;
    }

    public void setRole2(String role2) {
        this.role2 = role2 == null ? null : role2.trim();
    }

    public String getRole3() {
        return role3;
    }

    public void setRole3(String role3) {
        this.role3 = role3 == null ? null : role3.trim();
    }

    public String getRole4() {
        return role4;
    }

    public void setRole4(String role4) {
        this.role4 = role4 == null ? null : role4.trim();
    }

    public String getRole5() {
        return role5;
    }

    public void setRole5(String role5) {
        this.role5 = role5 == null ? null : role5.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }
}