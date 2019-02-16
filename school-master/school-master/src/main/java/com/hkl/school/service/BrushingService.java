package com.hkl.school.service;

import com.hkl.school.pojo.History;
import com.hkl.school.pojo.Question;

/**
 * author:hkl
 * Date:2018/10/14
 * Time:12:52
 */
public interface BrushingService {

    /**
     * 获得上次的问题id
     * @param type  类别
     * @param id    用户id
     * @return
     */
    History getLastHistoryByTypeAndId(String type,Long uid);


    /**
     * 获得新问题
     * @param type  类别
     * @param qid   上一题
     * @return
     */
    Question getNextQuestion(String type,Long qid);

    void addHistory(Long userid,String eids,String type,Long lastQuestionid);
}
