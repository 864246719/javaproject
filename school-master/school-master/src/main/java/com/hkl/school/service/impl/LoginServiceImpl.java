package com.hkl.school.service.impl;

import com.hkl.school.dao.UserMapper;
import com.hkl.school.pojo.User;
import com.hkl.school.pojo.UserExample;
import com.hkl.school.service.LoginSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:zwy
 * Date:2018/10/9
 * Time:13:42
 */
@Service
public class LoginServiceImpl implements LoginSerivce {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String account, String pwd) {

        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(account).andPwdEqualTo(pwd);
        List<User> users = userMapper.selectByExample(example);

        if (users.size()>0)
            return users.get(0);

        return null;
    }
}
