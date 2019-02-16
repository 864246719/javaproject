package com.hkl.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * author:hkl
 * Date:2018/10/13
 * Time:16:53
 */
@Controller
@RequestMapping("/student")
public class StudentIndexController {

    private final static String LOGIN = "/index.html";
    //学生主页面展示自己的姓名
    @RequestMapping("/loadUserNameAction")
    public @ResponseBody String loadUserName(HttpSession session){
        // 通过session调取姓名
        String userName = (String) session.getAttribute("uname");
        return userName;
    }

    @RequestMapping("/logoutAction")
    public String logout(HttpSession session){
        session.invalidate();
        return LOGIN;
    }


}
