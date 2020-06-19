package com.web.reseller.service;

import com.web.reseller.dao.L2OrderMapper;
import com.web.reseller.dao.L2TourMapper;
import com.web.reseller.dao.L2UserMapper;
import com.web.reseller.model.L2Order;
import com.web.reseller.model.L2Tour;
import com.web.reseller.model.L2User;
import com.web.reseller.util.message;
import com.web.reseller.util.result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
@Service
public class TravellerService {
    @Autowired
    private L2TourMapper l2TourMapper;

    @Autowired
    private L2OrderMapper l2OrderMapper;
    @Autowired
    private L2UserMapper l2UserMapper;
    public message createOrder(L2Order l2Order){
        l2OrderMapper.insert(l2Order);

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
public result operatorListAll(){
    List<L2User>list =l2UserMapper.resellersListAll();
    if (list.size()==0)
        return result.No_operator;
    result getResult=new result(200,list.size(),"success",list);
    return getResult;
}


}
