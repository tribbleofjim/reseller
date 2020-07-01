package com.web.reseller.service;

import com.web.reseller.dao.L2OrderMapper;
import com.web.reseller.dao.L2TourMapper;
import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.model.L2Order;
import com.web.reseller.model.L2Tour;
import com.web.reseller.model.L2User;
import com.web.reseller.util.KeyUtil;
import com.web.reseller.util.message;
import com.web.reseller.util.result;
import com.web.reseller.util.userForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TravellerService {
    @Autowired
    private L2TourMapper l2TourMapper;

    @Autowired
    private L2OrderMapper l2OrderMapper;

    @Autowired
    private L2UserMapper l2UserMapper;
    @Autowired
    private UserService userService;
    /**
     * 游客购买产品下单
     * 增加一条订单
     * @param userID
     * @param proID
     * @param num
     * @return
     */
    public message addOrder(String userID, String proID, String operatorID, int num) {
        L2Order l2Order = new L2Order();
        for(int i=0;i<num;i++){
            String orderID = KeyUtil.genUniqueKey();
            L2User l2User = l2UserMapper.login(userID);
            L2Tour l2Tour = l2TourMapper.SelectByID(proID);
            System.out.println(operatorID);
            String role3 = l2UserMapper.getSuperior(operatorID);
            String role4 = l2UserMapper.getSuperior(role3);
            String role5 = l2UserMapper.getSuperior(role4);
            l2Order.setBuyername(l2User.getLoginname());
            l2Order.setOrderid(orderID);
            l2Order.setBuyerphone(userID);
            l2Order.setTourid(proID);
            System.out.println(l2Tour.getId());
            l2Order.setTourprice(l2Tour.getPrice());
            l2Order.setRole1(userID);
            l2Order.setRole2(operatorID);
            l2Order.setRole3(role3);
            l2Order.setRole4(role4);
            l2Order.setRole5(role5);
            l2Order.setOrderstatus(0);//0:not paid 1:finished
            String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            l2Order.setCreatetime(Timestamp.valueOf(nowTime));
            l2OrderMapper.insert(l2Order);
        }
        return message.SUCCESS;
    }
    public result myproducts(String phonenumber){
        List<String>list1 = l2OrderMapper.selectOrderByPhone(phonenumber);
       Iterator I1 = list1.iterator();
       List<L2Tour>list2 = new ArrayList<>();
       while(I1.hasNext()){
          L2Tour l2tour =l2TourMapper.SelectByID((String) I1.next());
          list2.add(l2tour);
       }
        HashSet h = new HashSet(list2);
        list2.clear();
        list2.addAll(h);
        result getResult = new result(200,list2.size(),"success",list2);
       return getResult;
    }
    public userForm operatorListAll(){
            //展示所有分销商业务员
        List<L2User>list =l2UserMapper.resellersListAll();
        System.out.println(list);
        if (list.size()==0)
            return new userForm("404", 404, 0, list);
        return new userForm("0", 0, list.size(), list);
    }


}
