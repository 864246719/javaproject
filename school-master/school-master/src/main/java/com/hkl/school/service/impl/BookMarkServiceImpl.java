package com.hkl.school.service.impl;

import com.hkl.school.dao.BookMarkMapper;
import com.hkl.school.dao.QuestionMapper;
import com.hkl.school.pojo.Question;
import com.hkl.school.service.BookMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:zwy
 * Date:2018/10/13
 * Time:15:50
 */
@Service
public class BookMarkServiceImpl implements BookMarkService {

    @Autowired
    private BookMarkMapper bookMarkMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public Map<Object, Object> getBookMark(Long uid, Integer beginNumber, Integer pageSize) {
        int total = questionMapper.countFromBookMarkByUid(uid);
        List<Question> questions = questionMapper.selectFromBookMarkByUid(uid,beginNumber,pageSize);
        Map<Object,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("questions",questions);
        return map;
    }
}
