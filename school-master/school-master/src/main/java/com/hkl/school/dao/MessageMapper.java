package com.hkl.school.dao;

import com.hkl.school.pojo.Message;
import com.hkl.school.pojo.MessageExample;
import java.util.List;

import com.hkl.school.pojo.dto.MessageDTO;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    /**
     * 查询信息
     * @param messageId     信息id
     * @return
     */
    MessageDTO selectByMid(Long messageId);
}