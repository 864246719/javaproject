package com.hkl.school.service;

import com.hkl.school.pojo.User;

/**
 * author:hkl
 * Date:2018/10/9
 * Time:15:59
 */
public interface RegisterService {

    /**
     * 注册账户
     * @param account   账户
     * @param trueName  真实名
     * @param pwd   密码
     */
    void register(String account,String trueName,String pwd);

    /**
     * 账户是否注册
     * @param account 账户
     * @return  已注册返回true
     */
    boolean haveAccount(String account);
}
