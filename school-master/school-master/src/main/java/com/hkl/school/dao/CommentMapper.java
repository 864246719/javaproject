package com.hkl.school.dao;

import com.hkl.school.pojo.Comment;
import com.hkl.school.pojo.CommentExample;
import java.util.List;

import com.hkl.school.pojo.dto.CommentDTO;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    int countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByQuestionIdOrderByCreateTime(Long questionid);

    List<CommentDTO> selectDTOByQid(Long qid);
}