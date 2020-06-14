package com.web.reseller.model;

import java.math.BigDecimal;

public class L2Order {
    private Integer id;

    private String customer;

    private BigDecimal price;

    private String role1;

    private String role2;

    private String role3;

    private String role4;

    private String role5;

    private String product;

    private Integer status;

    public L2Order(Integer id, String customer, BigDecimal price, String role1, String role2, String role3, String role4, String role5, String product, Integer status) {
        this.id = id;
        this.customer = customer;
        this.price = price;
        this.role1 = role1;
        this.role2 = role2;
        this.role3 = role3;
        this.role4 = role4;
        this.role5 = role5;
        this.product = product;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer == null ? null : customer.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}