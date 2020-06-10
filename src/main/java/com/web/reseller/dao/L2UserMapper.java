package com.web.reseller.controller.dao;

import com.web.reseller.model.L2User;

public interface L2UserMapper {
    L2User login(String loginName);
}