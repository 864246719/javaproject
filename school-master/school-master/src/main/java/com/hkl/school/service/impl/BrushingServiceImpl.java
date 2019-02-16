package com.hkl.school.service.impl;

import com.hkl.school.dao.HistoryMapper;
import com.hkl.school.dao.QuestionMapper;
import com.hkl.school.pojo.History;
import com.hkl.school.pojo.Question;
import com.hkl.school.service.BrushingService;
import com.hkl.school.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:zwy
 * Date:2018/10/14
 * Time:12:56
 */
@Service
public class BrushingServiceImpl implements BrushingService {

    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public History getLastHistoryByTypeAndId(String type, Long uid) {
        return historyMapper.selectByUseridAndLastQuestionId(uid,type);
    }

    @Override
    public Question getNextQuestion(String type, Long qid) {
        return questionMapper.selectByLastQid(qid,type);
    }

    @Override
    public void addHistory(Long userid, String eids, String type, Long lastQuestionid) {
        String errorIds = eids.substring(0,eids.lastIndexOf("|"));
        History history = new History();
        history.setType(type);
        history.setUserId(userid);
        history.setLastQuestionId(lastQuestionid);
        history.setErrorIds(errorIds);
        historyMapper.insertSelective(history);
    }
}
