package com.hkl.school.service;

import com.hkl.school.pojo.Admin;

/**
 * author:hkl
 * Date:2018/10/28
 * Time:10:44
 */
public interface ManagerSelfService {

    Admin findById(Long adminId);

    void updateInformation(Admin admin);
}
