package com.web.reseller.controller;

import com.web.reseller.service.ResellerService;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/reseller")
public class ResellerController {

    @Autowired
    private ResellerService resellerService;

    @RequestMapping("/products")
    @ResponseBody
    public result productsList(@RequestParam(value = "phoneNumber") String phoneNumber){
        return resellerService.productsList(phoneNumber);
    }

    @RequestMapping("/operators")
    @ResponseBody
    public result operatorList(@RequestParam(value = "phoneNumber") String phonenumber){
        return resellerService.operatorList(phonenumber);
    }

    @RequestMapping("/superior")
    @ResponseBody
    public result getSuperior(@RequestParam(value = "phoneNumber") String phoneNumber){
        return resellerService.getSuperior(phoneNumber);
    }
}