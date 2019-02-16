package com.hkl.school.service;

import com.hkl.school.pojo.User;

/**
 * author:hkl
 * Date:2018/10/9
 * Time:13:41
 */
public interface LoginSerivce {

    /**
     * 登录
     * @param account
     * @param pwd
     * @return
     */
    User login(String account,String pwd);
}
