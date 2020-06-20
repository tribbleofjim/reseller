package com.web.reseller.controller;

import com.web.reseller.model.L2User;
import com.web.reseller.service.CompanyOperatorService;
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
    private CompanyOperatorService CompanyOperatorService;

    @RequestMapping("/products")
    @ResponseBody
    public result productsList(){
        return CompanyOperatorService.productsList();
    }

    @RequestMapping(value = "/resellers", method = RequestMethod.GET)
    @ResponseBody
    public result resellersList(@RequestParam(value = "phoneNumber") String phonenumber){
        return CompanyOperatorService.resellersList(phonenumber);
    }

    @RequestMapping(value = "/distribute", method = RequestMethod.GET)
    @ResponseBody
    public message distribute2reseller(@RequestParam(value = "phoneNumber") String phonenumber,@RequestParam(value = "productID") String productID){
        return CompanyOperatorService.distribute2reseller(phonenumber,productID);
    }
}
