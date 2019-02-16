package com.hkl.school.controller;

import com.hkl.school.pojo.Admin;
import com.hkl.school.service.ManagerSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * author:hkl
 * Date:2018/10/28
 * Time:10:42
 */
@RestController
@RequestMapping("/manager/managerSelf")
public class ManageSelfController {

    @Autowired
    private ManagerSelfService managerSelfService;

    /**
     * 加载信息
     * @param session
     * @return
     */
    @RequestMapping("/loadInfoAction")
    public Admin loadAdminInformation(HttpSession session){
        Long adminID = (Long) session.getAttribute("auid");
        return managerSelfService.findById(adminID);
    }

    @PostMapping("/updateInfoAction")
    public String updateInfo(HttpSession session,Admin admin){
        Long adminID = (Long) session.getAttribute("auid");
        admin.setId(adminID);
        managerSelfService.updateInformation(admin);
        session.setAttribute("auname",admin.getName());
        return "true";
    }
}
