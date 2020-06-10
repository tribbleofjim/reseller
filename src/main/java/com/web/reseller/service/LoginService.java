package com.web.reseller.service;

import com.web.reseller.controller.dao.L2UserMapper;
import com.web.reseller.model.L2User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.web.reseller.util.message;

@Service
public class LoginService {
    @Autowired
    private L2UserMapper l2UserMapper;

    /**
     * 登录方法
     * @param l2User
     * @return
     */
    public message login(L2User l2User){
        if(l2User == null) return message.NO_USER;
        L2User user = l2UserMapper.login(l2User.getLoginname());
        if(user == null) return message.NO_USER;
        if(!user.getPassword().equals(l2User.getPassword())) return message.PASSWORD_ERROR;
        return message.SUCCESS;
    }
}
