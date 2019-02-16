package com.hkl.school.dao;

import com.hkl.school.pojo.History;
import com.hkl.school.pojo.HistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryMapper {
    int countByExample(HistoryExample example);

    int deleteByExample(HistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(History record);

    int insertSelective(History record);

    List<History> selectByExample(HistoryExample example);

    History selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);

    int countByUserid(Long userid);

    List<History> selectByUseridPage(@Param("userid") Long userid,@Param("beginNumber") Integer beginNumber,@Param("pageSize") Integer pageSize);

    History selectByUseridAndLastQuestionId(@Param("userid") Long userid,@Param("type") String type);
}