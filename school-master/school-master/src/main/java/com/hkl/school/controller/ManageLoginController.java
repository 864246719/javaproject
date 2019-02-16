package com.hkl.school.controller;

import com.hkl.school.pojo.Admin;
import com.hkl.school.service.ManageLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * author:hkl
 * Date:2018/10/15
 * Time:15:28
 */
@RequestMapping("/manager")
@Controller
public class ManageLoginController {

    @Autowired
    private ManageLoginService manageLoginService;

    @RequestMapping("/loginAction")
    public @ResponseBody String login(String account, String pwd, HttpSession session){
        Admin admin = manageLoginService.adminLogin(account,pwd);
        if(admin==null){
            return "false";
        }else{
            //？？？？？？？？？？？？
            session.setAttribute("auid",admin.getId());
            session.setAttribute("auname",admin.getName());
            return "true";
        }
    }
}
