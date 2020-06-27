package com.web.reseller.service;

import com.web.reseller.dao.L2OrderMapper;
import com.web.reseller.dao.L2TourMapper;
import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.dao.L2role2productMapper;
import com.web.reseller.model.L2Role2product;
import com.web.reseller.model.L2Tour;
import com.web.reseller.model.L2User;
import com.web.reseller.util.result;
import com.web.reseller.util.message;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Service
public class OperatorService {
    @Autowired
	private L2OrderMapper l2OrderMapper;

	@Autowired
	private L2UserMapper l2UserMapper;

	public result percentage(String phonenumber){
        List<L2User>list =l2UserMapper.resellersList(phonenumber);
        if (list.size()==0)
            return result.No_percentage;
        result getResult=new result(200,list.size(),"success",list);
        return getResult;
    }
}
