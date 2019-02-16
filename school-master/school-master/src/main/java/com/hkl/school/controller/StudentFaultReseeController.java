package com.hkl.school.controller;

import com.hkl.school.pojo.Question;
import com.hkl.school.service.StudentFaultReseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/11
 * Time:16:04
 */
@Controller
@RequestMapping("/student/faultResee")
public class StudentFaultReseeController {

    @Autowired
    private StudentFaultReseeService studentFaultReseeService;

    @RequestMapping("/{hid}")
    public String toFaultResee(@PathVariable("hid") Long hid){
        return "/student/studentFaultResee.html";
    }

    @GetMapping("/findFaultsQuestionsAction")
    public @ResponseBody Map<Object,Object> findFaultHistory(Long hid){
        Map<Object,Object> map = new HashMap<>();
        List<Question> questions = studentFaultReseeService.getByHistoryId(hid);
        map.put("questions",questions);
        return map;
    }
}
