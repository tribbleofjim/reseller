package com.web.reseller.controller;

<<<<<<< HEAD
=======
import com.web.reseller.model.L2User;
>>>>>>> e32a355391da51cce3e26f53c6a3febbbd306185
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
<<<<<<< HEAD

=======
>>>>>>> e32a355391da51cce3e26f53c6a3febbbd306185
    @RequestMapping(value = "/finishiOrder")
    @ResponseBody
    public  message finishiOrder(@RequestParam(value = "orderID")String orderID){
        orderService.finishOrder(orderID);
        orderService.finishBonus(orderID);
        return message.SUCCESS;
    }

<<<<<<< HEAD
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
=======

>>>>>>> e32a355391da51cce3e26f53c6a3febbbd306185
}
