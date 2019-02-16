package com.hkl.school.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * author:hkl
 * Date:2018/9/26
 * Time:11:57
 */
public class FileIOUtil {

    private final static Logger logger = LoggerFactory.getLogger(FileIOUtil.class);//定义logger，打印日志用的

    /**
     * 单文件上传
     * @param saveDirectory
     * @param file
     * @return
     */
    //创建文件路径
    public static String singleFileUpload(String saveDirectory,MultipartFile file){

        String uuid = UUID.randomUUID().toString().replace("-","");//javaJDK提供的一个自动生成主键的方法
        String directoryPath = saveDirectory+File.separator+uuid;//separator路径分离符
        File file1 = new File(directoryPath);

        if(!file1.exists()){//防止文件夹不符合，需要重新建文件夹
            file1.mkdir();
        }
        //设置directoryPath路径   file.getOriginalFilename()名字
        File file2 =new File(directoryPath,file.getOriginalFilename());
        String filePath = "";
        try {
            file.transferTo(file2);
            //file.getOriginalFilename()获取文件的名字
            filePath = "/files"+directoryPath+"/"+file.getOriginalFilename();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    /**
     * 解析resource目录
     * @param resoucePath   resource目录
     * @return
     */
    public static String resolveResourePath(String resoucePath){
        String path = "";
        try {
             path = ResourceUtils.getFile("classpath:"+resoucePath).getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
