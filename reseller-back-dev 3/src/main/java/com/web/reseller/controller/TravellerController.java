package com.web.reseller.controller;

import com.web.reseller.model.L2Order;
import com.web.reseller.model.L2User;
import com.web.reseller.service.OrderService;
import com.web.reseller.service.TravellerService;
import com.web.reseller.service.UserService;
import com.web.reseller.util.message;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.web.reseller.util.KeyUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/traveller")
public class TravellerController {

    @Autowired
    private TravellerService travellerService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @RequestMapping("/myproducts")
    @ResponseBody
    public result myproducts(@RequestParam(value = "phonenumber") String phonenumber){
        return travellerService.myproducts(phonenumber) ;
    }
    @RequestMapping("/operators")
    @ResponseBody
    public result operatorListAll(){

        return travellerService.operatorListAll();
    }

    @RequestMapping("/createorder")
    @ResponseBody
    public message createOrder(@RequestParam(value = "phonenumber") String phonenumber,
                               @RequestParam(value = "productID") String productID,
                               @RequestParam(value = "tourprice") double tourprice,
                               @RequestParam(value = "operatorPhoneNumber") String operatorPhoneNumber,
                               @RequestParam(value = "number") int number,
                               @RequestParam(value = "buyername") String buyername)

    {int i;
for( i=0;i<number;i++){
       String orderID = KeyUtil.genUniqueKey();
        L2Order l2Order=new L2Order();
        l2Order.setBuyername(buyername);
        l2Order.setOrderid(orderID);
        l2Order.setBuyerphone(phonenumber);
        l2Order.setTourid(productID);
        l2Order.setTourprice(tourprice);
        l2Order.setRole1(phonenumber);
        l2Order.setRole2(operatorPhoneNumber);
        String role3 = userService.getSuperior(operatorPhoneNumber);
        l2Order.setRole3(role3);
        String role4 = userService.getSuperior(role3);
        l2Order.setRole4(role4);
        String role5 = userService.getSuperior(role4);
        l2Order.setRole5(role5);
        l2Order.setOrderstatus(0);//0:not paid 1:finished
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        l2Order.setCreatetime(Timestamp.valueOf(nowTime));

        travellerService.createOrder(l2Order);
    }
return message.SUCCESS;
}}
