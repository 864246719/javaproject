package com.hkl.school.service;

import com.hkl.school.pojo.Question;

import java.util.List;

/**
 * author:hkl
 * Date:2018/10/15
 * Time:17:37
 */
public interface ManageQuestionService {


    List<Question> loadQuestionPage(Integer beginNumber,Integer pageSize);

    void deleteQuestionById(Long qid);

    List<Question> loadByTypeAndTitleLike(String title,String type,Integer beginNumber,Integer pageSize);

    int countByTypeAndTitleLike(String title,String type);

}
