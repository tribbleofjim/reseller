package com.web.reseller.service;

import com.web.reseller.dao.L2TourMapper;
import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.dao.L2role2productMapper;
import com.web.reseller.model.L2Role2product;
import com.web.reseller.model.L2Tour;
import com.web.reseller.model.L2User;
import com.web.reseller.util.result;
import com.web.reseller.util.message;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Service
public class CompanyOperatorService {
    @Autowired
    private L2TourMapper l2TourMapper;
    @Autowired
    private L2UserMapper l2UserMapper;
    private L2OrderMapper l2OrderMapper;
    @Autowired
    private L2role2productMapper l2role2productMapper;
    public result productsList(){
     List<L2Tour>list =l2TourMapper.ProductList();
    if (list.size()==0)
        return result.No_product;
    result getResult=new result(200,list.size(),"success",list);
        return getResult;
    }

    public result resellersList(String phonenumber){
        List<L2User>list =l2UserMapper.resellersList(phonenumber);
        if (list.size()==0)
            return result.No_reseller;
        result getResult=new result(200,list.size(),"success",list);
        return getResult;
    }
    
    public result orderList(String phonenumber){
        List<L2Order>list =l2OrderMapper.resellersList(phonenumber);
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
}
