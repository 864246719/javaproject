package com.hkl.school.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * author:hkl
 * Date:2018/10/28
 * Time:15:12
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final static Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Value("${com.hkl.file-path}")
    private String filePath;

    /**
     * 访问外部文件配置
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        logger.info("文件路径:"+filePath);

        //配置server虚拟路径，handler为jsp中访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/files/**").addResourceLocations("file://"+filePath);
    }
}
