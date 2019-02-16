package com.hkl.school.dao;

import com.hkl.school.pojo.BookMark;
import com.hkl.school.pojo.BookMarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMarkMapper {
    int countByExample(BookMarkExample example);

    int deleteByExample(BookMarkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BookMark record);

    int insertSelective(BookMark record);

    List<BookMark> selectByExample(BookMarkExample example);

    BookMark selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BookMark record, @Param("example") BookMarkExample example);

    int updateByExample(@Param("record") BookMark record, @Param("example") BookMarkExample example);

    int updateByPrimaryKeySelective(BookMark record);

    int updateByPrimaryKey(BookMark record);

    List<BookMark> selectByUidPage(@Param("uid") Long uid,@Param("beginNumber") Integer beginNumber,@Param("pageSize") Integer pageSize);
}