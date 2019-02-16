package com.hkl.school.service;

import com.hkl.school.pojo.Question;

import java.util.Date;
import java.util.List;

/**
 * author:hkl
 * Date:2018/10/9
 * Time:16:14
 */
public interface TestService {

    /**
     * 按顺序获得问题
     * @param beginNumber   开始条数
     * @param pageSize  每页显示条数
     * @return
     */
    List<Question> getQuestionSortable(Integer beginNumber,Integer pageSize,String type);


    /**
     * 获得乱序的n条
     * @param numbers
     * @return
     */
    List<Question> getQuestionNotSort(Integer numbers,String type);

    /**
     * 添加历史
     * @param userid    用户id
     * @param score     分数
     * @param questionids   问题的主键
     * @param errorids      错误的主键
     */
    void addHistory(Long userid,Float score,Long[] questionids,Long[] errorids);

    /**
     * 添加历史
     * @param userid    用户id
     * @param score     分数
     * @param questionids   问题的主键
     * @param errorids      错误的主键
     * @param startDate     开始时间
     */
    void addHistory(Long userid,Float score,Long[] questionids,Long[] errorids,Date startDate,String type);

}
