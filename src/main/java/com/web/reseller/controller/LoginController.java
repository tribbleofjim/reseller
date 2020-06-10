package com.web.reseller.controller;

import com.web.reseller.model.L2User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.web.reseller.service.LoginService;
import com.web.reseller.util.message;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/webLogin")
    @ResponseBody
    public message login(@RequestParam(value = "loginName") String loginName,
                         @RequestParam(value = "password") String password){
        L2User l2User = new L2User();
        l2User.setLoginname(loginName);
        l2User.setPassword(password);
        return loginService.login(l2User);
    }
}
