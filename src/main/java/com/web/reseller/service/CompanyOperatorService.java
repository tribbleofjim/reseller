package com.web.reseller.service;

import com.web.reseller.dao.L2OrderMapper;
import com.web.reseller.dao.L2TourMapper;
import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.dao.L2role2productMapper;
import com.web.reseller.model.L2Order;
import com.web.reseller.model.L2Role2product;
import com.web.reseller.model.L2Tour;
import com.web.reseller.model.L2User;
import com.web.reseller.util.result;
import com.web.reseller.util.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyOperatorService {
    @Autowired
    private L2TourMapper l2TourMapper;
    @Autowired
    private L2UserMapper l2UserMapper;

    @Autowired
    private L2OrderMapper l2OrderMapper;

    @Autowired
    private L2role2productMapper l2role2productMapper;
    public result productsList(){
     List<L2Tour> list =l2TourMapper.ProductList();
    if (list.size()==0)
        return result.No_product;
    result getResult=new result(200,list.size(),"success",list);
        return getResult;
    }

    public result getProductsList(String phoneNumber){
        List<L2Tour>list =l2TourMapper.getProductList(phoneNumber);
        if (list.size()==0)
            return result.No_product;
        return new result(200,list.size(),"success",list);
    }

    public result resellersList(String phonenumber){
        List<L2User>list =l2UserMapper.resellersList(phonenumber);
        if (list.size()==0)
            return result.No_reseller;
        result getResult=new result(200,list.size(),"success",list);
        return getResult;
    }
    
    public result orderList(String phonenumber){
        List<L2Order>list = l2OrderMapper.comOperOrderList(phonenumber);
        if (list.size()==0)
            return result.No_order;
        result getResult=new result(200,list.size(),"success",list);
        return getResult;
    }
    
    public message distribute2reseller(String phonenumber,String productID){
        if(phonenumber==null||productID==null)
            return message.No_phone_productID;
        L2Role2product role = new L2Role2product(phonenumber,productID);
        l2role2productMapper.distribute2reseller(role);

        return message.SUCCESS;
    }

    public result operOrderList(String phoneNumber) {
        List<L2Order> list = l2OrderMapper.operatorOrderList(phoneNumber);
        if (list.size()==0)
            return result.No_order;
        result getResult=new result(200,list.size(),"success",list);
        return getResult;
    }
}
