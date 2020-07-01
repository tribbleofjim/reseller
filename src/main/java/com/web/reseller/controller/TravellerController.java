package com.web.reseller.controller;

<<<<<<< HEAD
import com.web.reseller.service.OrderService;
import com.web.reseller.service.TravellerService;
import com.web.reseller.service.UserService;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
=======
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
>>>>>>> e32a355391da51cce3e26f53c6a3febbbd306185
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
<<<<<<< HEAD
=======
import com.web.reseller.util.KeyUtil;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
>>>>>>> e32a355391da51cce3e26f53c6a3febbbd306185

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
