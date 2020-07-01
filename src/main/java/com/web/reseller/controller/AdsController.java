package com.web.reseller.controller;


import com.web.reseller.model.L2User;
import com.web.reseller.service.*;
import com.web.reseller.util.message;
<<<<<<< HEAD
=======
import com.web.reseller.util.result;
>>>>>>> e32a355391da51cce3e26f53c6a3febbbd306185
import com.web.reseller.util.userForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ads")
public class AdsController {

    @Autowired
    private TourService tourService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private TravellerService travellerService;

    @Autowired
    private UserService userService;

    /**
     * 从广告二维码跳转到报名页面
     * @param userProID
     * @param model
     * @return
     */
    @RequestMapping("/getForm")
    public String getForm(@RequestParam(value = "userProID") String userProID,
//                          @RequestParam(value = "proID") String proID,
                          Model model){
        String userID = userProID.split(":")[0];
        String proID = userProID.split(":")[1];
        //TODO: 计算该广告点击量，即userID代表的人的业绩
        userService.publicizePlus(userID);
         // 判断是否需要选择分销商业务员
        L2User l2User = userService.getUser(userID);
        boolean isChooseOperator = true;
        if(!"二级业务员".equals(l2User.getRole())){
            isChooseOperator = false;
        }

        // 设置页面参数
        model.addAttribute("user", userID);
        model.addAttribute("product", tourService.getProducts(proID));
        model.addAttribute("isChooseOperator", isChooseOperator);
        return "getForm";
    }

    /**
     * 展示分销商业务员列表
     * @return
     */
    @RequestMapping("/operators")
    @ResponseBody
    public userForm operatorListAll(){
        return travellerService.operatorListAll();
    }

    /**
     * 游客下单购买产品
     * TODO: 扣提成逻辑还未完成
     * @param userID
     * @param proID
     * @param operatorID
     * @param num
     * @return
     */
    @RequestMapping("/createorder")
    @ResponseBody
    public message createOrder(@RequestParam(value = "userID") String userID,
                               @RequestParam(value = "proID") String proID,
                               @RequestParam(value = "operatorID") String operatorID,
                               @RequestParam(value = "num") String num) {
        int number = Integer.parseInt(num);
        return travellerService.addOrder(userID, proID, operatorID, number);
    }

}
