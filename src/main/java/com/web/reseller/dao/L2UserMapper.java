package com.web.reseller.dao;

import com.web.reseller.model.L2User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface L2UserMapper {
    L2User login(String phonenumber);
    List<L2User> resellersList(String phonenumber);
    List<L2User> resellersListAll();
    String getSuperior(String ID);
    boolean userUpdate(L2User l2User);
    void register(L2User l2User);}