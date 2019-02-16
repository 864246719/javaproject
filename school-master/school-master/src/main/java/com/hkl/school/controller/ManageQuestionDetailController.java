package com.hkl.school.controller;

import com.hkl.school.service.ManageQuestionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author:hkl
 * Date:2018/10/16
 * Time:11:18
 */
@Controller
@RequestMapping("/manager/questionDetail")
public class ManageQuestionDetailController {
    //删除评论
    private final static String QUESTION_DETAIL = "/manager/manageQuestionDetail.html";

    @Autowired
    private ManageQuestionDetailService manageQuestionDetailService;

    @RequestMapping("/{qid}")
    public String toQuestionDetail(@PathVariable("qid") Long qid){
        return QUESTION_DETAIL;
    }

    @PostMapping("/deleteCommentAction")
    public @ResponseBody String deleteComment(Long cid){
        manageQuestionDetailService.deleteCommentByCid(cid);
        return "true";
    }


}
