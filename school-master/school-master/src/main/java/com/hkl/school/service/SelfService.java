package com.hkl.school.service;

import com.hkl.school.pojo.User;

/**
 * author:hkl
 * Date:2018/10/11
 * Time:16:56
 */
public interface SelfService {

    /**
     * 更新用户信息
     * @param user
     */
    void updateMsg(User user);

    /**
     * 加载用户信息
     * @param userid
     * @return
     */
    User loadUserInfo(Long userid);
}
