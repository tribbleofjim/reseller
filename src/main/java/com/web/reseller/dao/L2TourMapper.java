package com.web.reseller.dao;

import com.web.reseller.model.L2Tour;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface L2TourMapper {
    List<L2Tour> ProductList();
    List<L2Tour> getProductList(String phoneNumber);
    L2Tour SelectByID(String proId);
}
