package com.web.reseller.service;
import com.web.reseller.controller.dao.L2UserMapper;
import com.web.reseller.util.message;

import com.web.reseller.model.L2User;
import com.web.reseller.util.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private L2UserMapper l2UserMapper;

    public message register(L2User l2User){
        if(l2User==null)return message.NO_USER;
        if (l2User.getAge()<=0)
            return message.Wrong_age;
        if(l2User.getCity()==null)
            return message.Wrong_city;
        if(l2User.getQqnumber()==null||l2User.getQqnumber().length()>10)
            return message.Wrong_QQNumber;
        if(l2User.getPhonenumber()==null||l2User.getPhonenumber().length()!=11)
            return message.Wrong_PhoneN;

        l2UserMapper.register(l2User);
        return message.Reg_Success;
    }
}
