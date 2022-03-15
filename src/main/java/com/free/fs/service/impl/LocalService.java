package com.free.fs.service.impl;

import com.free.fs.common.template.LocalTemplate;
import com.free.fs.model.FilePojo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author : wuxiao
 * @date : 19:28 2022/3/11
 */
@Service
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "local")
public class LocalService extends AbstractIFileService{

    @Resource
    private LocalTemplate localTemplate;


    @Override
    protected void deleteFile(String url) {
        localTemplate.delete(url);
    }

    @Override
    protected FilePojo uploadFile(MultipartFile file) {
        System.out.println("20:25 2022/3/11 LocalService LocalFile" );
        return null;
    }

    @Override
    protected FilePojo uploadFileSharding(MultipartFile file, HttpSession session) {
        System.out.println("20:25 2022/3/11 LocalService uploadFileSharding" );
        return null;
    }

    @Override
    protected String switchingStorage() {
        String str = "20:25 2022/3/11 LocalService switchingStorage 当前对象存储方式为 local" ;
        return str;
    }


    @Override
    public void download(String url, HttpServletResponse response) {
        localTemplate.download(url, response);
    }




}
