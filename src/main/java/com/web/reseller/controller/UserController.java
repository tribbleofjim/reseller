package com.web.reseller.controller;

import com.web.reseller.model.L2User;
import com.web.reseller.service.OrderService;
import com.web.reseller.service.UserService;
import com.web.reseller.util.message;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.core.annotation.Order;
>>>>>>> e32a355391da51cce3e26f53c6a3febbbd306185
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
    @Autowired
    private OrderService orderService;

    @RequestMapping("/operatorUpgrade")
    @ResponseBody
    public message operatorUpgrade(@RequestParam(value = "phonenumber") String phonenumber,
                                   @RequestParam(value = "password") String password,
                                   @RequestParam(value = "role") String role){
        return userService.userUpdate(phonenumber,password,role);
    }

    @RequestMapping("/webLogin")
    @ResponseBody
    public message login(@RequestParam(value = "phonenumber") String phonenumber,
                         @RequestParam(value = "password") String password){
        L2User l2User = new L2User();
        l2User.setPhonenumber(phonenumber);
        l2User.setPassword(password);
        return userService.login(l2User);
    }

    @RequestMapping("/bonusOfAorder")
    @ResponseBody
    public double bonusOfAorder(@RequestParam(value = "role") String role,
                                @RequestParam(value = "orderID") String orderID){
        return orderService.bonusOfAorder(role,orderID);
    }
    @RequestMapping("/bonusOfAll")
    @ResponseBody
    public double bonusOfAll(@RequestParam(value = "phonenumber")String phonenumber ){
        L2User l2User =userService.getUser(phonenumber);
        return l2User.getBonus();
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
