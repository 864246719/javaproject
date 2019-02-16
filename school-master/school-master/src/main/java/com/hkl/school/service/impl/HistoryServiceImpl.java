package com.hkl.school.service.impl;

import com.hkl.school.dao.HistoryMapper;
import com.hkl.school.pojo.History;
import com.hkl.school.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:zwy
 * Date:2018/10/11
 * Time:14:22
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public Map<Object, Object> getUserHistoryPage(Long userid, Integer beginNumber, Integer pageSize) {
        int count = historyMapper.countByUserid(userid);
        List<History> histories = historyMapper.selectByUseridPage(userid,beginNumber,pageSize);
        Map<Object,Object> map = new HashMap<>();
        map.put("total",count);
        map.put("histories",histories);
        return map;
    }
}
