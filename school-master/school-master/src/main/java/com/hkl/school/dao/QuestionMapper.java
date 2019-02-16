package com.hkl.school.dao;

import com.hkl.school.pojo.Question;
import com.hkl.school.pojo.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {
    int countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    /**
     * 根据类别分页查询
     * @param beginNumber   开始条数
     * @param pageSize  每页显示条数
     * @param type  类别
     * @return
     */
    List<Question> selectByTypePage(@Param("beginNumber") Integer beginNumber,@Param("pageSize") Integer pageSize,@Param("type") String type);

    /**
     * 获得科目的所有id
     * @param type
     * @return
     */
    List<Long> selectIdsByType(String type);

    /**
     * 通过id集合获取question
     * @param ids
     * @return
     */
    List<Question> selectByIds(@Param("ids") List<Long> ids);

    /**
     * 获得随机的若干条
     * @param type  类别
     * @param number    条数
     * @return
     */
    List<Question> selectRandomByType(@Param("type") String type,@Param("number") Integer number);

    List<Question> selectFromBookMarkByUid(@Param("uid") Long uid,@Param("beginNumber") Integer beginNumber,@Param("pageSize") Integer pageSize);

    int countFromBookMarkByUid(Long uid);

    Question selectByLastQid(@Param("qid") Long id,@Param("type") String type);

    List<Question> selectByTypeAndTitleLikePage(@Param("type") String type,@Param("title") String title,@Param("beginNumber") Integer beginNumber,@Param("pageSize") Integer pageSize);

    int countByTypeAndTitleLike(@Param("type") String type,@Param("title") String title);
}