package com.free.fs.service.impl;

import com.free.fs.common.template.MinioTemplate;
import com.free.fs.model.FilePojo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author : wangjun
 * @date : 12:14 2022/3/16
 */
@Service
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "minio")
public class MinioService extends AbstractIFileService{

    @Resource
    private MinioTemplate minioTemplate;

    @Override
    protected FilePojo uploadFile(MultipartFile file) {
        System.out.println("20:25 2022/3/11 MinioService uploadFile" );
        FilePojo filePojo = minioTemplate.upload(file);
        return filePojo;
    }

    @Override
    protected FilePojo uploadFileSharding(MultipartFile file, HttpSession session) {
        System.out.println("20:25 2022/3/11 MinioService uploadFileSharding" );
        return minioTemplate.uploadSharding(file, session);
    }

    @Override
    protected String switchingStorage() {
        String str = "20:25 2022/3/11 LocalService switchingStorage 当前对象存储方式为 minio" ;
        return str;
    }


    @Override
    protected void deleteFile(String url) {
        minioTemplate.delete(url);
    }

    @Override
    public void download(String url, HttpServletResponse response) {
        minioTemplate.download(url, response);
    }
}
