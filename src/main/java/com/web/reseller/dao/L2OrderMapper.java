package com.web.reseller.dao;

import java.util.List;

import com.web.reseller.model.L2Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface L2OrderMapper {
    List<String> selectOrderByPhone(String phonenumber);
    List<L2Order> comOperOrderList(String phonenumber);
    List<L2Order> distributorOrderList(String phoneNumber);
    List<L2Order> operatorOrderList(String phoneNumber);
    void insert(L2Order l2Order);
    void finishOrder(String orderID,String nowTime);
    String getProduct(String orderID);
    L2Order getOrderByID(String orderID);
}