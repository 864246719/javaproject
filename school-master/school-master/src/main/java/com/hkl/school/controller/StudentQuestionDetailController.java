package com.hkl.school.controller;

import com.hkl.school.pojo.BookMark;
import com.hkl.school.pojo.Comment;
import com.hkl.school.pojo.Question;
import com.hkl.school.pojo.Suppose;
import com.hkl.school.pojo.dto.CommentDTO;
import com.hkl.school.service.QuestionDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/12
 * Time:10:50
 */

@Controller
@RequestMapping("/student/questionDetail")
public class StudentQuestionDetailController {

    private final static Logger logger = LoggerFactory.getLogger(StudentQuestionDetailController.class);

    @Autowired
    private QuestionDetailService questionDetailService;

    /**
     * 界面跳转
     * @param qid
     * @return
     */
    @GetMapping("/{qid}")
    public String toQestionDetail(@PathVariable("qid") String qid){
        logger.info("进入:"+qid);
        return "/student/seeQuestionDetail.html";
    }

    /**
     * 加载问题
     * @param qid
     * @return
     */
    @GetMapping("/loadQuestionAction")
    public @ResponseBody Question loadQuestion(Long qid){
        return questionDetailService.getByQid(qid);
    }

    /**
     * 加载评论
     * @param qid
     * @return
     */
    @GetMapping("/loadCommentsAction")
    public @ResponseBody List<CommentDTO> loadComments(Long qid){
        return questionDetailService.getDTOByQid(qid);
    }

    /**
     * 加载点赞数
     * @param qid
     * @return
     */
    @GetMapping("/loadSupposeAction")
    public @ResponseBody Map<Object,Object> loadSuppsed(Long qid){
        return questionDetailService.getSuppose(qid);
    }

    /**
     * 加载是否点赞
     * @param qid
     * @param session
     * @return
     */
    @GetMapping("/loadIsSupposedAction")
    public @ResponseBody Suppose isSupposed(Long qid,HttpSession session){
        Long userid = (Long) session.getAttribute("uid");
        return questionDetailService.isSupposed(qid,userid);
    }

    /**
     * 添加评论
     * @param session
     * @param qid
     * @param content
     * @return
     */
    @PostMapping("/addCommentAction")
    public @ResponseBody String addComment(HttpSession session,Long qid,String content){
        Long userid = (Long) session.getAttribute("uid");
        questionDetailService.addComment(userid,qid,content);
        return "true";
    }

    /**
     * 添加赞
     * @param session
     * @param qid   问题id
     * @param suppose   点赞情况
     * @return
     */
    @PostMapping("/addSupposeAction")
    public @ResponseBody String addSuppose(HttpSession session,Long qid,Byte suppose){
        Long userid = (Long) session.getAttribute("uid") ;
        Suppose suppose1 = questionDetailService.isSupposed(qid,userid);
        if (null!=suppose1)
            return "已点赞";

        questionDetailService.addSuppose(qid,userid,suppose);
        return "true";
    }

    @GetMapping("/isBookMarkAction")
    public @ResponseBody String isBookMark(HttpSession session,Long qid){
        Long userid = (Long) session.getAttribute("uid");
        BookMark bookMark = questionDetailService.isBookMark(qid,userid);
        if(null==bookMark)
            return "false";
        return "true";
    }

    @PostMapping("/addOrCancelBookMarkAction")
    public @ResponseBody String addOrCancelBookMark(HttpSession session,Long qid){
        Long userid = (Long) session.getAttribute("uid");
        return questionDetailService.addOrCancelBookMark(qid,userid);
    }

    @GetMapping("/loadAllInformation")
    public @ResponseBody Map<Object,Object> loadAllInformation(Long qid, HttpSession session){
        Long userid = (Long) session.getAttribute("uid");
        Map<Object,Object> map = new HashMap<>();
        Map<Object,Object> map1 = questionDetailService.getSuppose(qid);
        map.putAll(map1);
        Question question = questionDetailService.getByQid(qid);
        //
        Suppose suppose = questionDetailService.isSupposed(qid,userid);
        List<Comment> comments = questionDetailService.getCommentsByQid(qid);
        map.put("question",question);
        map.put("suppose",suppose);
        map.put("comments",comments);
        return map;
    }
}
