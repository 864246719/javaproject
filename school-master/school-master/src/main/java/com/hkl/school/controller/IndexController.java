package com.hkl.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author:hkl
 * Date:2018/10/15
 * Time:15:11
 */
@RequestMapping("/")
@Controller
public class IndexController {
    //直接加载首页面，调取static包中已有的页面
    private final static String INDEX = "/index.html";//

    @RequestMapping("/")
    public String toRoot(){
        return INDEX;
    }

    @RequestMapping("/index")
    public String toIndex(){
        return INDEX;
    }
}
