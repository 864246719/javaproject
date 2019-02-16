package com.hkl.school.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 添加题目
 * author:hkl
 * Date:2018/10/10
 * Time:10:18
 */
public interface AddQuestionService {

    /**
     * 添加题目
     * @param userid    添加人的id
     * @param title     标题
     * @param type      类别
     * @param answers   答案
     * @param questions 问题
     * @param imageurl  图片路径
     * @param vediourl  视频路径
     * @param content   讲解
     */
    //直接调用添加问题dao的方法
    void addQuestion(Long userid,String title,String type,String answers,String questions,String imageurl,String vediourl,String content);

    String uploadImage(MultipartFile file);

    String uploadVedio(MultipartFile file);
}
