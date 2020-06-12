package com.web.reseller.controller.dao;

import com.web.reseller.model.L2User;
import org.apache.ibatis.annotations.Param;

public interface L2UserMapper {
    L2User login(String loginName);

void register(L2User l2User);
}