package com.hkl.school.service;


import com.hkl.school.pojo.Question;

import java.util.List;

/**
 * author:hkl
 * Date:2018/10/11
 * Time:15:51
 */
public interface StudentFaultReseeService {

    /**
     * 根据history id获得错题的id
     * @param id    history id
     * @return
     */
    List<Question> getByHistoryId(Long id);
}
