package com.hkl.school.service;

import com.hkl.school.pojo.History;

import java.util.List;
import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/11
 * Time:14:19
 */
public interface HistoryService {

    /**
     * 获得用户的历史
     * @param userid    用户id
     * @param beginNumber   开始条数
     * @param pageSize      每页显示条数
     * @return      total->总数   historys->数据
     */
    Map<Object,Object> getUserHistoryPage(Long userid, Integer beginNumber, Integer pageSize);
}
