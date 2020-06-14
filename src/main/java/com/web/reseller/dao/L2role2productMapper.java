package com.web.reseller.dao;

import com.web.reseller.model.L2Role2product;
import com.web.reseller.model.L2Tour;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface L2role2productMapper {
    void distribute2reseller(L2Role2product role);
}
