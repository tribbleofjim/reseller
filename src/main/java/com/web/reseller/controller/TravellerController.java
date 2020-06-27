package com.web.reseller.controller;

import com.web.reseller.model.L2Order;
import com.web.reseller.model.L2User;
import com.web.reseller.service.OrderService;
import com.web.reseller.service.TravellerService;
import com.web.reseller.service.UserService;
import com.web.reseller.util.message;
import com.web.reseller.util.result;
import com.web.reseller.util.userForm;
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
    public result myproducts(@RequestParam(value = "phoneNumber") String phonenumber){
        return travellerService.myproducts(phonenumber) ;
    }

}
