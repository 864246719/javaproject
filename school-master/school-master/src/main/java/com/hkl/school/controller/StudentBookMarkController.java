package com.hkl.school.controller;

import com.hkl.school.service.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/13
 * Time:15:59
 */
@Controller
@RequestMapping("/student/bookMark")
public class StudentBookMarkController {

    @Autowired
    private BookMarkService bookMarkService;

    @GetMapping("/loadBookMarkAction")
    public @ResponseBody Map<Object,Object> loadBookMark(HttpSession session, Integer beginNumber, Integer pageSize){
        Long userid = (Long) session.getAttribute("uid");
        return bookMarkService.getBookMark(userid,beginNumber,pageSize);
    }
}
