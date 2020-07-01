package com.web.reseller.model;

public class L2Role2product {
    private String phonenumber;

    private String productid;

    public L2Role2product(String phonenumber, String productid) {
        this.phonenumber = phonenumber;
        this.productid = productid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }
}
