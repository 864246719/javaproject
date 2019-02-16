package com.hkl.school.controller;

import com.hkl.school.pojo.User;
import com.hkl.school.service.LoginSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * author:hkl
 * Date:2018/10/10
 * Time:11:24
 */
@Controller
@RequestMapping("/")  //
public class LoginController {

    @Autowired
    private LoginSerivce loginSerivce;

    private final static String LOGIN = "/login.html";

    @PostMapping("/loginAction")
    public @ResponseBody String login(String name, String pwd, HttpSession session){
        User user = loginSerivce.login(name,pwd);//用户仅一个
        if (null!=user){ //用户不是空的话
            session.setAttribute("uid",user.getId());  //数据库的uid和输入的id是否相同
            session.setAttribute("uname",user.getAccount());//数据库uname和输入的uname是否相同
            return "ok";
        }else
            return "error";

    }
}
