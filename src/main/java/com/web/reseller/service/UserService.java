package com.web.reseller.service;

import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.model.L2User;
import com.web.reseller.util.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private L2UserMapper l2UserMapper;

    /**
     * 登录方法
     * @param l2User
     * @return
     */
    public message login(L2User l2User){
        if(l2User.getPhonenumber() == null) return message.No_Phonenumber;

        if(l2User.getPassword()==null) return message.No_Password;

        L2User user = l2UserMapper.login(l2User.getPhonenumber());

        if(user == null) return message.NO_USER;
        if(!user.getPassword().equals(l2User.getPassword())) return message.PASSWORD_ERROR;

        if (user.getRole().equals("游客"))
            return message.SUCCESS_5;
        if (user.getRole().equals("二级业务员"))
            return message.SUCCESS_4;
        if (user.getRole().equals("分销商"))
            return message.SUCCESS_3;
        if (user.getRole().equals("一级业务员"))
            return message.SUCCESS_2;
        if (user.getRole().equals("公司"))
            return message.SUCCESS_1;
        return message.No_ROLE;
    }

    /**
     * 注册方法
     * @param l2User
     * @return
     */
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
