package com.hkl.school.service;

import java.util.Map;

/**
 * author:hkl
 * Date:2018/10/13
 * Time:15:48
 */
public interface BookMarkService {

    Map<Object,Object> getBookMark(Long uid, Integer beginNumber, Integer pageSize);
}
