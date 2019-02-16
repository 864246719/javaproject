package com.hkl.school.controller;

import com.hkl.school.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author:hkl
 * Date:2018/10/10
 * Time:11:27
 */
@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/isRegisteredAction")
    public @ResponseBody String isRegistered(String account){
        boolean flag = registerService.haveAccount(account);
        if (flag)
            return "ok";
        return "error";
    }

    @PostMapping("/register")
    public @ResponseBody String register(String account, String trueName, String pwd){
        registerService.register(account,trueName,pwd);
        return "ok";
    }
}
