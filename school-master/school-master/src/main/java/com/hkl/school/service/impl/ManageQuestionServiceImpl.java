package com.hkl.school.service.impl;

import com.hkl.school.dao.QuestionMapper;
import com.hkl.school.pojo.Question;
import com.hkl.school.service.ManageQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:zwy
 * Date:2018/10/15
 * Time:17:41
 */
@Service
public class ManageQuestionServiceImpl implements ManageQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> loadQuestionPage(Integer beginNumber, Integer pageSize) {
        return questionMapper.selectByTypeAndTitleLikePage(null,null,beginNumber,pageSize);
    }

    @Override
    public void deleteQuestionById(Long qid) {
        questionMapper.deleteByPrimaryKey(qid);
    }

    @Override
    public List<Question> loadByTypeAndTitleLike(String title, String type, Integer beginNumber, Integer pageSize) {
        String getTitle;
        String getType;
        if(null==title ||title.trim().equals("")||title.trim().equals("null"))
            getTitle = null;
        else
            getTitle = "%"+title+"%";
        if(null==type||type.trim().equals("")||type.trim().equals("null"))
            getType = null;
        else
            getType = type;
        return questionMapper.selectByTypeAndTitleLikePage(getType,getTitle,beginNumber,pageSize);
    }

    @Override
    public int countByTypeAndTitleLike(String title, String type) {
        String getTitle;
        String getType;
        if(null==title ||title.trim().equals("")||title.trim().equals("null"))
            getTitle = null;
        else
            getTitle = "%"+title+"%";
        if(null==type||type.trim().equals("")||type.trim().equals("null"))
            getType = null;
        else
            getType = type;
        return questionMapper.countByTypeAndTitleLike(getType,getTitle);
    }
}
