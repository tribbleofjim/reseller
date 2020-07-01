package com.web.reseller.model;

import java.math.BigDecimal;

public class L2Tour {
    private String name;

    private String picture;

    private double price;

    private String info;

    private Integer sales;

    private String id;

//    @Override
//    public boolean equals(Object obj){
//        L2Tour t=(L2Tour)obj;
//        return id.equals(t.id);
//    }
//    @Override
//    public int hasCode(){
//        String in = id;
//        return in.hashCode();
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    private String companyID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}