package com.web.reseller.controller;

import com.web.reseller.model.L2User;
import com.web.reseller.service.UserService;
import com.web.reseller.util.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/webLogin")
    @ResponseBody
    public message login(@RequestParam(value = "phonenumber") String phonenumber,
                         @RequestParam(value = "password") String password){
        L2User l2User = new L2User();
        l2User.setPhonenumber(phonenumber);
        l2User.setPassword(password);
        return userService.login(l2User);
    }

    @RequestMapping(value = "/webRegister", method = RequestMethod.POST)
    @ResponseBody
    public message register(@RequestParam(value = "loginName") String loginName,
                            @RequestParam(value = "password") String password,@RequestParam(value = "confirmPassword")String confirmPassword,@RequestParam(value = "age") int age,
                            @RequestParam(value = "city") String city,@RequestParam(value = "phoneNumber") String phonenumber,
                            @RequestParam(value = "qqNumber") String qqnumber,@RequestParam(value = "role")String role){
        String confirm =confirmPassword;
        if(confirm==password)
            return message.Confirm_Password;

            L2User l2User = new L2User();
            l2User.setLoginname(loginName);
            l2User.setPassword(password);
            l2User.setAge(age);
            l2User.setCity(city);
            l2User.setPhonenumber(phonenumber);
            l2User.setQqnumber(qqnumber);
            l2User.setRole(role);
        return userService.register(l2User);
    }
}
