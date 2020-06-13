package com.web.reseller.dao;

import com.web.reseller.model.L2User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface L2UserMapper {
    L2User login(String loginName);

    void register(L2User l2User);
}