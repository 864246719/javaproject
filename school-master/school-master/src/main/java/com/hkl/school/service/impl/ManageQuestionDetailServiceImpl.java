package com.hkl.school.service.impl;

import com.hkl.school.dao.CommentMapper;
import com.hkl.school.service.ManageQuestionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:zwy
 * Date:2018/10/16
 * Time:11:46
 */
@Service
public class ManageQuestionDetailServiceImpl implements ManageQuestionDetailService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void deleteCommentByCid(Long cid) {
        commentMapper.deleteByPrimaryKey(cid);
    }
}
