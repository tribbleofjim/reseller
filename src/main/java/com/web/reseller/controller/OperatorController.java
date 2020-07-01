package com.web.reseller.controller;

import com.web.reseller.service.CompanyOperatorService;
import com.web.reseller.service.OrderService;
import com.web.reseller.service.UserService;
import com.web.reseller.util.message;
import com.web.reseller.util.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/oper")
public class OperatorController {

    @Autowired
    private CompanyOperatorService companyOperatorService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    /**
     * 展示提成
     * @param phonenumber
     * @return
     */
    @RequestMapping(value = "/percentage", method = RequestMethod.GET)
    @ResponseBody
    public result percentage(@RequestParam(value = "phoneNumber") String phonenumber){
        return userService.percentage(phonenumber);
    }
    @RequestMapping(value = "/finishiOrder")
    @ResponseBody
    public  message finishiOrder(@RequestParam(value = "orderID")String orderID){
        orderService.finishOrder(orderID);
        orderService.finishBonus(orderID);
        return message.SUCCESS;
    }


    @RequestMapping(value = "/orders")
    @ResponseBody
    public result ordertsList(@RequestParam(value = "phoneNumber") String phoneNumber){
        return companyOperatorService.operOrderList(phoneNumber);
    }

    @RequestMapping("/products")
    @ResponseBody
    public result productsList(@RequestParam(value = "phoneNumber") String phoneNumber){
        return companyOperatorService.getProductsList(phoneNumber);
    }
}
