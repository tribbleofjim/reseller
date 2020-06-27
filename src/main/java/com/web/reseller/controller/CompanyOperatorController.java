package com.web.reseller.controller;

import com.web.reseller.model.L2User;
import com.web.reseller.service.CompanyOperatorService;
import com.web.reseller.service.ResellerService;
import com.web.reseller.service.UserService;
import com.web.reseller.util.message;
import com.web.reseller.util.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/comoper")
public class CompanyOperatorController {

    @Autowired
    private CompanyOperatorService companyOperatorService;

    @Autowired
    private ResellerService resellerService;

    @RequestMapping("/products")
    @ResponseBody
    public result productsList(){
        return companyOperatorService.productsList();
    }

    @RequestMapping(value = "/resellers")
    @ResponseBody
    public result resellersList(@RequestParam(value = "phoneNumber") String phonenumber){
        return companyOperatorService.resellersList(phonenumber);
    }

    @RequestMapping(value = "/orders")
    @ResponseBody
    public result ordertsList(@RequestParam(value = "phoneNumber") String phoneNumber){
        return companyOperatorService.orderList(phoneNumber);
    }
    
    @RequestMapping(value = "/distribute")
    @ResponseBody
    public message distribute2reseller(@RequestParam(value = "phoneNumber") String phonenumber,@RequestParam(value = "productID") String productID){
        return companyOperatorService.distribute2reseller(phonenumber,productID);
    }
}
