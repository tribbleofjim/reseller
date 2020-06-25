package com.web.reseller.service;

import com.web.reseller.dao.L2TourMapper;
import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.model.L2Tour;
import com.web.reseller.model.L2User;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResellerService {
    @Autowired
    private L2TourMapper l2TourMapper;
    @Autowired
    private L2UserMapper l2UserMapper;
    public result productsList(String phoneNumber){
        List<L2Tour> list =l2TourMapper.getProductList(phoneNumber);
        if (list.size()==0)
            return result.No_product;
        result getResult=new result(200,list.size(),"success",list);
        return getResult;
    }

    public result operatorList(String phonenumber){
        List<L2User>list =l2UserMapper.resellersList(phonenumber);
        if (list.size()==0)
            return result.No_operator;
        result getResult=new result(200,list.size(),"success",list);
        return getResult;
    }

    public result getSuperior(String phoneNumber){
        return new result(200, 0, "success", l2UserMapper.getSuperior(phoneNumber));
    }
}
