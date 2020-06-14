package com.web.reseller.controller;

import com.web.reseller.model.L2User;
import com.web.reseller.service.TravellerService;
import com.web.reseller.service.UserService;
import com.web.reseller.util.message;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/traveller")
public class TravellerController {

    @Autowired
    private TravellerService travellerService;
    @RequestMapping("/operators")
    @ResponseBody
    public result operatorListAll(){

        return travellerService.operatorListAll();
    }
//
//    @RequestMapping("/createorder")
//    @ResponseBody
//    public message createOrder(@RequestParam(value = "phonenumber") String phonenumber,
//                         @RequestParam(value = "productID") String productID,@RequestParam(value = "cost") int cost){
//
//        L2User l2User = new L2User();
//        l2User.setPhonenumber(phonenumber);
//        l2User.setPassword(password);
//        return travellerService.createOrder(l2User);
//    }
}
