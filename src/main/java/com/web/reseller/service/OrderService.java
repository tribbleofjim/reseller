package com.web.reseller.service;

import com.web.reseller.dao.L2OrderMapper;
import com.web.reseller.dao.L2TourMapper;
import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.model.L2Order;
import com.web.reseller.model.L2Tour;
import com.web.reseller.model.L2User;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {
    @Autowired
    private L2OrderMapper l2OrderMapper;

    @Autowired
    private L2UserMapper l2UserMapper;

    @Autowired
    private L2TourMapper l2TourMapper;


}
