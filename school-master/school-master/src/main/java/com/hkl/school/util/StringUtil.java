package com.hkl.school.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * author:hkl
 * Date:2018/10/10
 * Time:14:24
 */
public class StringUtil {

    public static String arrayToString(String[] strs){
        StringBuilder builder = new StringBuilder();
        for (String s:strs){
            builder.append(s+"|");
        }

        String str = builder.toString();

        return str.substring(0,str.lastIndexOf("|")-1);
    }

    public static String arrayToString(Long[] strs){
        StringBuilder builder = new StringBuilder();
        for (Long s:strs){
            builder.append(s+"|");
        }
        String str = builder.toString();
        return str.substring(0,str.lastIndexOf("|")-1);
    }

    public static String asciiToUTF8(String type){
        String result = "";
        try {
            result = URLDecoder.decode(type, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
