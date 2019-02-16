package com.hkl.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * author:hkl
 * Date:2018/10/15
 * Time:15:51
 */
@RequestMapping("/manager")
@Controller
public class ManageIndexController {
    //主页面自己的姓名展示
    @RequestMapping("/getNameAction")
    public @ResponseBody String getAdminName(HttpSession session){
        String adminName = (String) session.getAttribute("auname");
        return adminName;
    }
}
