package com.web.reseller.dao;

import com.web.reseller.model.L2Order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface L2OrderMapper {


    int insert(L2Order record);

    int insertSelective(L2Order record);

   List<String> selectOrderByPhone(String phonenumber);

}