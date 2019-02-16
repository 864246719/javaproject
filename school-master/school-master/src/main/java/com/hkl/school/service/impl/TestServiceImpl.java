package com.hkl.school.service.impl;

import com.hkl.school.dao.HistoryMapper;
import com.hkl.school.dao.QuestionMapper;
import com.hkl.school.pojo.History;
import com.hkl.school.pojo.Question;
import com.hkl.school.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author:zwy
 * Date:2018/10/9
 * Time:16:25
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public List<Question> getQuestionSortable(Integer beginNumber, Integer pageSize,String type) {
        return questionMapper.selectByTypePage(beginNumber,pageSize,type);
    }

    @Override
    public List<Question> getQuestionNotSort(Integer numbers,String type) {
        return questionMapper.selectRandomByType(type,numbers);
    }

    @Override
    public void addHistory(Long userid, Float score, Long[] questionids, Long[] errorids) {

        StringBuilder qids = new StringBuilder();
        StringBuilder eids = new StringBuilder();

        for(Long l:questionids){
            qids.append(l+"|");
        }

        for(Long l:errorids){
            eids.append(l+"|");
        }

        String getQid = qids.toString().substring(0,qids.lastIndexOf("|"));
        String getEid = eids.toString().substring(0,eids.lastIndexOf("|"));

        History history = new History();
        history.setQuestionIds(getQid);
        history.setErrorIds(getEid);
        history.setScore(score);
        history.setUserId(userid);

        historyMapper.insertSelective(history);
    }

    @Override
    public void addHistory(Long userid, Float score, Long[] questionids, Long[] errorids, Date startDate,String type) {
        StringBuilder qids = new StringBuilder();
        StringBuilder eids = new StringBuilder();

        for(Long l:questionids){
            qids.append(l+"|");
        }

        for(Long l:errorids){
            eids.append(l+"|");
        }

        String getQid = qids.toString().substring(0,qids.lastIndexOf("|"));

        String getEid = "";
        if(eids.toString()!=null&&!eids.toString().trim().equals(""))
            getEid = eids.toString().substring(0,eids.lastIndexOf("|"));

        History history = new History();
        history.setQuestionIds(getQid);
        history.setErrorIds(getEid);
        history.setScore(score);
        history.setUserId(userid);
        history.setBeginTime(startDate);
        history.setType(type);
        historyMapper.insertSelective(history);
    }
}
