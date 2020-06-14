package com.web.reseller.service;

import com.web.reseller.dao.L2OrderMapper;
import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.model.L2Order;
import com.web.reseller.model.L2Tour;
import com.web.reseller.model.L2User;
import com.web.reseller.util.message;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TravellerService {
    @Autowired
    private L2OrderMapper l2OrderMapper;
    @Autowired
    private L2UserMapper l2UserMapper;
//    public message createOrder(L2Order l2Order){
//
//
//        return message.SUCCESS;
//    }
public result operatorListAll(){
    List<L2User>list =l2UserMapper.resellersListAll();
    if (list.size()==0)
        return result.No_operator;
    result getResult=new result(200,list.size(),"success",list);
    return getResult;
}
}
