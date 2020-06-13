package com.web.reseller.dao;

import com.web.reseller.model.L2User;
import org.springframework.stereotype.Component;

@Component
public interface L2UserMapper {
    L2User login(String loginName);
}