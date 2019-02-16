package com.hkl.school.dao;

import com.hkl.school.pojo.Suppose;
import com.hkl.school.pojo.SupposeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupposeMapper {
    int countByExample(SupposeExample example);

    int deleteByExample(SupposeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Suppose record);

    int insertSelective(Suppose record);

    List<Suppose> selectByExample(SupposeExample example);

    Suppose selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Suppose record, @Param("example") SupposeExample example);

    int updateByExample(@Param("record") Suppose record, @Param("example") SupposeExample example);

    int updateByPrimaryKeySelective(Suppose record);

    int updateByPrimaryKey(Suppose record);
}