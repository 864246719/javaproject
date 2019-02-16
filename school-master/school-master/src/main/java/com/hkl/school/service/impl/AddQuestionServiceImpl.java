package com.hkl.school.service.impl;

import com.hkl.school.dao.QuestionMapper;
import com.hkl.school.pojo.Question;
import com.hkl.school.service.AddQuestionService;
import com.hkl.school.util.FileIOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * author:hkl
 * Date:2018/10/10
 * Time:10:22
 */
@Service
public class AddQuestionServiceImpl implements AddQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Value("${com.hkl.file-path}")
    private String basePath;

    @Override
    public void addQuestion(Long userid, String title, String type, String answers, String questions, String imageurl, String vediourl,String content) {
        //添加的问题放入question对象中
        Question question = new Question();
        question.setUserid(userid);
        question.setTitle(title);
        question.setType(type);
        question.setAnswer(answers);
        question.setSelects(questions);
        question.setContent(content);

        if (null!=imageurl&&!imageurl.trim().equals("")) //trim()去掉多余的字符
            question.setImages(imageurl);

        if (null!=vediourl&&!vediourl.trim().equals(""))
            question.setVedios(vediourl);

        questionMapper.insertSelective(question) ; //放入问题map集合中
    }
    //添加图片
    @Override
    public String uploadImage(MultipartFile file) {
        //调用自己声明的FileIOUtil使用单文件上传
        return FileIOUtil.singleFileUpload(basePath+"/image",file);//singleFileUpload单文件的上传
    }

    //添加video
    @Override
    public String uploadVedio(MultipartFile file) {
        //调用自己声明的FileIOUtil使用单文件上传
        return FileIOUtil.singleFileUpload(basePath+"/vedio",file);//singleFileUpload单文件的上传
    }
}
