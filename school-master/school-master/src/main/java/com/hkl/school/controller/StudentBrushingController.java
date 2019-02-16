package com.hkl.school.controller;

import com.hkl.school.pojo.History;
import com.hkl.school.pojo.Question;
import com.hkl.school.service.BrushingService;
import com.hkl.school.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.Date;

/**
 * author:hkl
 * Date:2018/10/14
 * Time:12:38
 */
@Controller
@RequestMapping("/student/studentBrushing")
public class StudentBrushingController {

    @Autowired
    private BrushingService brushingService;

    @RequestMapping("/{type}")
    public String toBrushing(@PathVariable("type") String type){
        return "/student/studentBrushing.html";
    }

    @GetMapping("/getQuestionAction")
    public @ResponseBody Question getQuestion(HttpSession session, String type, Long lastQid) throws Exception{
        Long userid = (Long) session.getAttribute("uid");
        if(lastQid==null){
            History history = brushingService.getLastHistoryByTypeAndId(URLDecoder.decode(type, "utf-8"),userid);
            if (history==null)
                lastQid = 0L;
            else
                lastQid = history.getLastQuestionId();
        }
        Question question = brushingService.getNextQuestion(URLDecoder.decode(type, "utf-8"),lastQid);
        return question;
    }

    @PostMapping("/addHistoryAction")
    public @ResponseBody String addHistory(HttpSession session, String eids,String type,Long lastQuestionid){
        Long userid = (Long) session.getAttribute("uid");

        if(!eids.equals(""))
            brushingService.addHistory(userid,eids, StringUtil.asciiToUTF8(type),lastQuestionid);
        return "true";
    }
}
