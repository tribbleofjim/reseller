package com.web.reseller.service;

import com.web.reseller.dao.L2OrderMapper;
import com.web.reseller.dao.L2TourMapper;
import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.model.L2Order;
<<<<<<< HEAD
import com.web.reseller.util.message;
=======
import com.web.reseller.model.L2Tour;
import com.web.reseller.model.L2User;
import com.web.reseller.util.message;
import com.web.reseller.util.result;
>>>>>>> e32a355391da51cce3e26f53c6a3febbbd306185
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderService {
    @Autowired
    private L2OrderMapper l2OrderMapper;

    @Autowired
    private L2UserMapper l2UserMapper;

    @Autowired
    private L2TourMapper l2TourMapper;

    public message finishOrder(String orderID){
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        l2OrderMapper.finishOrder(orderID,nowTime);


        return message.SUCCESS;
    }
    public message finishBonus(String orderID){
        L2Order l2Order = l2OrderMapper.getOrderByID(orderID);
        l2UserMapper.bonusPlus(l2Order.getRole2(),l2Order.getTourprice()*0.1);
        l2UserMapper.bonusPlus(l2Order.getRole3(),l2Order.getTourprice()*0.2);
        l2UserMapper.bonusPlus(l2Order.getRole4(),l2Order.getTourprice()*0.3);
        l2UserMapper.bonusPlus(l2Order.getRole5(),l2Order.getTourprice()*0.4);
        return message.SUCCESS;
    }
    public double bonusOfAorder(String role,String orderID){
        L2Order l2Order = l2OrderMapper.getOrderByID(orderID);
        if(role.equals("二级业务员"))
            return l2Order.getTourprice()*0.1;
        if(role.equals("分销商"))
            return l2Order.getTourprice()*0.2;
        if(role.equals("一级业务员"))
            return l2Order.getTourprice()*0.3;
        if(role.equals("公司"))
            return l2Order.getTourprice()*0.4;
        else return 0;
    }


}
