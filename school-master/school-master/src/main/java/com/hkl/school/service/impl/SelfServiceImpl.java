package com.hkl.school.service.impl;

import com.hkl.school.dao.UserMapper;
import com.hkl.school.pojo.User;
import com.hkl.school.service.SelfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * author:zwy
 * Date:2018/10/11
 * Time:16:57
 */
@Service
public class SelfServiceImpl implements SelfService{
    private final static Logger logger = LoggerFactory.getLogger(SelfServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateMsg(User user) {
        logger.info("获得当前时间"+new Date());
        user.setModifiedTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User loadUserInfo(Long userid) {
        return userMapper.selectByPrimaryKey(userid);
    }
}
