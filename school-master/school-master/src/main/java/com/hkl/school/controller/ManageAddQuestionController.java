package com.hkl.school.controller;

import com.hkl.school.service.AddQuestionService;
import com.hkl.school.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * author:hkl
 * Date:2018/10/10
 * Time:14:15
 * 管理员添加问题
 */
@Controller
@RequestMapping("/manager/addQuestion")
public class ManageAddQuestionController {

    @Autowired
    private AddQuestionService addQuestionService;  //调取逻辑层 使用逻辑层的操作参数  ？？？？
    //上传题库图片
    @RequestMapping("/uploadQuestionImageAction")
    public @ResponseBody String uploadImage(MultipartFile file, HttpSession session){
        String filePath = addQuestionService.uploadImage(file);
        //这一步的作用是什么
        session.setAttribute("questionImageFilePath",filePath);//把图片的路径存入questionImageFilePath
        return "true";
    }
    //上传视屏
    @RequestMapping("/uploadQuestionVedioAction")
    public @ResponseBody String uploadVedio(MultipartFile file, HttpSession session){
        String filePath = addQuestionService.uploadImage(file);
        session.setAttribute("questionVedioFilePath",filePath);//上传视屏的路径放入key中
        return "true";
    }
    //添加问题
    @RequestMapping("/addQuestionAction")
    public @ResponseBody String addQuestion(HttpSession session,String title,String answers,String selects,String type,String content){
        String imageUrl = (String) session.getAttribute("questionImageFilePath");//通过get
        String vedioUrl = (String) session.getAttribute("questionVedioFilePath");
        Long userid = (Long) session.getAttribute("auid");
        addQuestionService.addQuestion(userid,title,type,answers,selects,imageUrl,vedioUrl,content);
        return "ok";
    }
}
