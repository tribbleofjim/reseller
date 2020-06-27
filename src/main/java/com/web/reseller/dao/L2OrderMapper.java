package com.web.reseller.dao;

import com.web.reseller.model.L2Order;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface L2OrderMapper {
    List<String> selectOrderByPhone(String phonenumber);
    List<L2Order> comOperOrderList(String phonenumber);
    List<L2Order> distributorOrderList(String phoneNumber);
    List<L2Order> operatorOrderList(String phoneNumber);
    void insert(L2Order l2Order);
}