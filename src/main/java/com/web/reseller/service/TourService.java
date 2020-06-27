package com.web.reseller.service;

import com.web.reseller.dao.L2TourMapper;
import com.web.reseller.model.L2Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    @Autowired
    private L2TourMapper l2TourMapper;

    public L2Tour getProducts(String proID){
        return l2TourMapper.SelectByID(proID);
    }
}
