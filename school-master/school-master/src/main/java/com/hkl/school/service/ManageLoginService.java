package com.hkl.school.service;

import com.hkl.school.pojo.Admin;

/**
 * author:hkl
 * Date:2018/10/15
 * Time:15:29
 */
public interface ManageLoginService {

     Admin adminLogin(String account,String pwd);
}
