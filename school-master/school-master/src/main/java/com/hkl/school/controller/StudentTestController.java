package com.hkl.school.controller;

import com.hkl.school.pojo.Question;
import com.hkl.school.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/10
 * Time:16:35
 */
@Controller
@RequestMapping("/student/selfTest")
public class StudentTestController {

    private final static Logger logger = LoggerFactory.getLogger(StudentTestController.class);

    @RequestMapping("/{type}")
    public String toStudentTest(@PathVariable("type") String type){
        logger.info("类别:"+type);
        return "/student/studentTest.html";
    }

    @Autowired
    private TestService testService;

    @RequestMapping("/makeTestAction")
    public @ResponseBody Map<Object,Object> makeTest(String type, Integer number) throws Exception{
        logger.info("获得的类别:"+ URLDecoder.decode(type, "utf-8"));
        List<Question> questions = testService.getQuestionNotSort(number,URLDecoder.decode(type, "utf-8"));
        Map<Object,Object> map = new HashMap<>();
        map.put("questions",questions);
        return map;
    }

    @PostMapping("/addHistoryAction")
    public @ResponseBody String addHistory(HttpSession session, Float score,@RequestParam("qids[]") Long[] qids, @RequestParam("eids[]") Long[] eids, Date startDate,String type)throws Exception{
        Long userid = (Long) session.getAttribute("uid");

        if (eids[0]==0l)
            eids = new Long[]{};

        testService.addHistory(userid,score,qids,eids,startDate,URLDecoder.decode(type, "utf-8"));
        return "true";
    }
}
