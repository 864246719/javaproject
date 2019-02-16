package com.hkl.school.controller;

import com.hkl.school.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/11
 * Time:14:37
 */
@Controller
@RequestMapping("/student/history")
public class StudentHistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/getHistoryAction")
    public @ResponseBody Map<Object,Object> findUserHistory(HttpSession session, Integer beginNumber, Integer pageSize){
        Map<Object,Object> map = new HashMap<>();
        Long userid = (Long) session.getAttribute("uid");
        map = historyService.getUserHistoryPage(userid,beginNumber,pageSize);
        return map;
    }
}
