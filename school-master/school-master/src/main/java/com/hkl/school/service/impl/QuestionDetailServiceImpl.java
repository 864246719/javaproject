package com.hkl.school.service.impl;

import com.hkl.school.dao.BookMarkMapper;
import com.hkl.school.dao.CommentMapper;
import com.hkl.school.dao.QuestionMapper;
import com.hkl.school.dao.SupposeMapper;
import com.hkl.school.pojo.*;
import com.hkl.school.pojo.dto.CommentDTO;
import com.hkl.school.service.QuestionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:zwy
 * Date:2018/10/12
 * Time:10:22
 */
@Service
public class QuestionDetailServiceImpl implements QuestionDetailService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private SupposeMapper supposeMapper;

    @Autowired
    private BookMarkMapper bookMarkMapper;

    @Override
    public Question getByQid(Long qid) {
        return questionMapper.selectByPrimaryKey(qid);
    }

    @Override
    public List<Comment> getCommentsByQid(Long qid) {
        return commentMapper.selectByQuestionIdOrderByCreateTime(qid);
    }

    @Override
    public Map<Object, Object> getSuppose(Long qid) {
        SupposeExample example = new SupposeExample();
        Byte value = 0;
        example.createCriteria().andQuestionIdEqualTo(qid).andSupposeEqualTo(value);
        int supposed = supposeMapper.countByExample(example);

        SupposeExample example1 = new SupposeExample();
        value = 1;
        example1.createCriteria().andQuestionIdEqualTo(qid).andSupposeEqualTo(value);
        int notSupposed = supposeMapper.countByExample(example1);

        Map<Object,Object> map = new HashMap<>();
        map.put("supposed",supposed);
        map.put("notSupposed",notSupposed);
        return map;
    }

    @Override
    public Suppose isSupposed(Long qid, Long uid) {

        SupposeExample example = new SupposeExample();
        example.createCriteria().andQuestionIdEqualTo(qid).andUserIdEqualTo(uid);

        List<Suppose> supposes = supposeMapper.selectByExample(example);

        if(supposes.size()>0)
            return supposes.get(0);

        return null;
    }

    @Override
    public List<CommentDTO> getDTOByQid(Long qid) {
        return commentMapper.selectDTOByQid(qid);
    }

    @Override
    public void addComment(Long userid, Long questionid, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUserId(userid);
        comment.setQuestionId(questionid);
        commentMapper.insertSelective(comment);
    }

    @Override
    public void addSuppose(Long qid, Long uid, Byte suppose) {

        //判断是否已经点过赞了
        SupposeExample example = new SupposeExample();
        example.createCriteria().andQuestionIdEqualTo(qid).andUserIdEqualTo(uid);
        List<Suppose> supposes = supposeMapper.selectByExample(example);
        if (supposes.size()>0)
            return;

        Suppose suppose1 = new Suppose();
        suppose1.setQuestionId(qid);
        suppose1.setUserId(uid);
        suppose1.setSuppose(suppose);
        supposeMapper.insertSelective(suppose1);
    }

    @Override
    public void addBookMark(Long qid, Long uid) {
        BookMark bookMark = new BookMark();
        bookMark.setQustionId(qid);
        bookMark.setUserId(uid);
        bookMarkMapper.insertSelective(bookMark);
    }

    @Override
    public void cancelBookMark(Long qid, Long uid) {
        BookMarkExample example = new BookMarkExample();
        example.createCriteria().andQustionIdEqualTo(qid).andUserIdEqualTo(uid);
        bookMarkMapper.deleteByExample(example);
    }

    @Override
    public String addOrCancelBookMark(Long qid, Long uid) {
        BookMark bookMark = isBookMark(qid,uid);
        if(null==bookMark){
            addBookMark(qid,uid);
            return "true";
        }else
            cancelBookMark(qid,uid);
            return "false";
    }

    @Override
    public BookMark isBookMark(Long qid, Long uid) {
        BookMarkExample example = new BookMarkExample();
        example.createCriteria().andUserIdEqualTo(uid).andQustionIdEqualTo(qid);
        List<BookMark> bookMarks = bookMarkMapper.selectByExample(example);
        if(bookMarks.size()>0)
            return bookMarks.get(0);
        return null;
    }

    @Override
    public List<Comment> loadCommentByQidPage(Long qid, Integer beginNumber, Integer pageSize) {
        return null;
    }

    @Override
    public int countCommnetByQid(Long qid) {
        return 0;
    }
}
