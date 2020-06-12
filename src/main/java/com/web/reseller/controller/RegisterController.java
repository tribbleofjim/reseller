package com.web.reseller.controller;

import com.web.reseller.model.L2User;
import com.web.reseller.service.RegisterService;
import com.web.reseller.util.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping("/webRegister")
    @ResponseBody
    public message register(@RequestParam(value = "loginName") String loginName,
                            @RequestParam(value = "password") String password,@RequestParam(value = "age") int age,
                            @RequestParam(value = "city") String city,@RequestParam(value = "phonenumber") String phonenumber,
                            @RequestParam(value = "qqnumber") String qqnumber){
        L2User l2User = new L2User();
        l2User.setLoginname(loginName);
        l2User.setPassword(password);
        l2User.setAge(age);
        l2User.setCity(city);
        l2User.setPhonenumber(phonenumber);
        l2User.setQqnumber(qqnumber);

        return registerService.register(l2User);
    }
}
