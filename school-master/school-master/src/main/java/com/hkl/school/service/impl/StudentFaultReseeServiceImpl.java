package com.hkl.school.service.impl;

import com.hkl.school.dao.HistoryMapper;
import com.hkl.school.dao.QuestionMapper;
import com.hkl.school.pojo.History;
import com.hkl.school.pojo.Question;
import com.hkl.school.service.StudentFaultReseeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author:hkl
 * Date:2018/10/11
 * Time:15:55
 */
@Service
public class StudentFaultReseeServiceImpl implements StudentFaultReseeService {

    private final static Logger logger = LoggerFactory.getLogger(StudentFaultReseeServiceImpl.class);

    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> getByHistoryId(Long id) {
        History history = historyMapper.selectByPrimaryKey(id);
        if(!history.getErrorIds().trim().equals("")){
            String[] questionIds = history.getErrorIds().split("\\|");

            List<Long> qids = new ArrayList<>();
            for (int i = 0; i < questionIds.length; i++) {
                qids.add( Long.parseLong(questionIds[i]) );
            }
            return questionMapper.selectByIds(qids);
        }else
            return null;
    }
}
