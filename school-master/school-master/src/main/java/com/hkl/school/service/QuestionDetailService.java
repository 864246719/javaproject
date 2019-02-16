package com.hkl.school.service;

import com.hkl.school.pojo.BookMark;
import com.hkl.school.pojo.Comment;
import com.hkl.school.pojo.Question;
import com.hkl.school.pojo.Suppose;
import com.hkl.school.pojo.dto.CommentDTO;

import java.util.List;
import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/12
 * Time:10:21
 */
public interface QuestionDetailService {

    Question getByQid(Long qid);

    /**
     * 根据qid查询评论
     * @param qid
     * @return
     */
    List<Comment> getCommentsByQid(Long qid);

    List<CommentDTO> getDTOByQid(Long qid);

    /**
     * 获得赞和踩
     * @param qid   问题id
     * @return
     */
    Map<Object,Object> getSuppose(Long qid);

    /**
     * 检验是否已经点过赞
     * @param qid
     * @param uid
     * @return  未点赞返回null
     */
    Suppose isSupposed(Long qid, Long uid);

    /**
     * 添加评论
     * @param userid    用户id
     * @param questionid    问题的id
     * @param content   内容
     */
    void addComment(Long userid,Long questionid,String content);

    /**
     * 添加赞或者踩
     * @param qid   问题id
     * @param uid   用户id
     */
    void addSuppose(Long qid,Long uid,Byte suppose);

    /**
     * 添加收藏
     * @param qid
     * @param uid
     */
    void addBookMark(Long qid,Long uid);

    /**
     * 删除收藏
     * @param qid
     * @param uid
     */
    void cancelBookMark(Long qid,Long uid);

    /**
     * 添加或取消 收藏
     * @param qid   问题id
     * @param uid   用户id
     */
    String addOrCancelBookMark(Long qid,Long uid);

    /**
     * 是否已收藏
     * @param qid   问题id
     * @param uid   用户id
     * @return
     */
    BookMark isBookMark(Long qid,Long uid);

    /**
     * 分页查询
     * @param qid
     * @param beginNumber
     * @param pageSize
     * @return
     */
    List<Comment> loadCommentByQidPage(Long qid,Integer beginNumber,Integer pageSize);

    /**
     * 总数
     * @param qid
     * @return
     */
    int countCommnetByQid(Long qid);


}
