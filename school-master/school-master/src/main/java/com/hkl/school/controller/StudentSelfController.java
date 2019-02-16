package com.hkl.school.controller;

import com.hkl.school.pojo.User;
import com.hkl.school.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/11
 * Time:16:58
 */
@RestController
@RequestMapping("/student/self")
public class StudentSelfController {

    @Autowired
    private SelfService selfService;

    @PostMapping("/updateSelfAction")
    public String updateSelf(HttpSession session, User user){

        Long userid = (Long) session.getAttribute("uid");
        user.setId(userid);
        selfService.updateMsg(user);

        return "true";
    }

    @RequestMapping("/loadInfoAction")
    public Map<Object,Object> loadUserInfo(HttpSession session){
        Long userid = (Long) session.getAttribute("uid");
        Map<Object,Object> map = new HashMap<>();
        User user = selfService.loadUserInfo(userid);
        map.put("user",user);
        return map;
    }
}
