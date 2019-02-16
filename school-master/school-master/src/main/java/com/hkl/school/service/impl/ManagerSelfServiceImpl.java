package com.hkl.school.service.impl;

import com.hkl.school.dao.AdminMapper;
import com.hkl.school.pojo.Admin;
import com.hkl.school.service.ManagerSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author:zwy
 * Date:2018/10/28
 * Time:10:45
 */
@Service
public class ManagerSelfServiceImpl implements ManagerSelfService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findById(Long adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public void updateInformation(Admin admin) {
        adminMapper.updateByPrimaryKeySelective(admin);
    }
}
