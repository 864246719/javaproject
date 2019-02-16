package com.hkl.school.controller;

import com.hkl.school.pojo.Question;
import com.hkl.school.service.ManageQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/16
 * Time:09:33
 */


@Controller
@RequestMapping("/manager/manageQuestion")
public class ManageQuestionController {

    @Autowired
    private ManageQuestionService manageQuestionService;
    //加载问题
    @GetMapping("/loadQuestionAction")
    public @ResponseBody Map<Object,Object> loadQuestion(Integer beginNumber, Integer pageSize, String type, String title){
        Map<Object,Object> map = new HashMap<>();
        int total = manageQuestionService.countByTypeAndTitleLike(title,type);
        List<Question> questions = manageQuestionService.loadByTypeAndTitleLike(title,type,beginNumber,pageSize);
        map.put("total",total);
        map.put("questions",questions);
        return map;
    }
    //管理员删除问题
    @PostMapping("/deleteQuestionAction")
    public @ResponseBody String deleteQuestion(Long qid){
        manageQuestionService.deleteQuestionById(qid);
        return "true";
    }
}
