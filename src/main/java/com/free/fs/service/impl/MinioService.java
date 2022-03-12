package com.free.fs.service.impl;

import com.free.fs.common.template.MinioTemplate;
import com.free.fs.common.template.OssTemplate;
import com.free.fs.model.FilePojo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : wuxiao
 * @date : 20:58 2022/3/11
 */
@Service
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "minio")
public class MinioService extends AbstractIFileService{

    @Resource
    private MinioTemplate minioTemplate;

    @Override
    protected FilePojo uploadFile(MultipartFile file) {
        return null;
    }

    @Override
    protected void deleteFile(String url) {
        minioTemplate.delete(url);
    }

    @Override
    public void download(String url, HttpServletResponse response) {
        System.out.println("20:25 2022/3/11 MinioService download" );
    }
}
