package com.hkl.school.service.impl;

import com.hkl.school.dao.UserMapper;
import com.hkl.school.pojo.User;
import com.hkl.school.pojo.UserExample;
import com.hkl.school.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:zwy
 * Date:2018/10/9
 * Time:16:03
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(String account, String trueName, String pwd) {

        User user = new User();
        user.setAccount(account);
        user.setTrueName(trueName);
        user.setPwd(pwd);
        user.setNickName(account);

        userMapper.insertSelective(user);


    }

    @Override
    public boolean haveAccount(String account) {

        UserExample example = new UserExample();
        example.createCriteria().andAccountEqualTo(account.trim());
        List<User> users = userMapper.selectByExample(example);
        return users.size()<=0;
    }
}
