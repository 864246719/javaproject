package com.hkl.school.service.impl;

import com.hkl.school.dao.AdminMapper;
import com.hkl.school.pojo.Admin;
import com.hkl.school.pojo.AdminExample;
import com.hkl.school.service.ManageLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:zwy
 * Date:2018/10/15
 * Time:15:30
 */
@Service
public class ManageLoginServiceImpl implements ManageLoginService {

    @Autowired
    private AdminMapper mapper;

    @Override
    public Admin adminLogin(String account, String pwd) {
        AdminExample example = new AdminExample();
        example.createCriteria().andAccountEqualTo(account).andPwdEqualTo(pwd);
        List<Admin> admins = mapper.selectByExample(example);
        if(admins.size()>0)
            return admins.get(0);
        return null;
    }
}
