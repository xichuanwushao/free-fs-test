package com.free.fs.service.impl;

import com.free.fs.common.template.OssTemplate;
import com.free.fs.model.FilePojo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author : wuxiao
 * @date : 20:57 2022/3/11
 */
@Service
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "oss")
public class OssService extends AbstractIFileService{

    @Resource
    private OssTemplate ossTemplate;

    @Override
    protected FilePojo uploadFile(MultipartFile file) {
        System.out.println("20:25 2022/3/11 OssService uploadFile" );
        return null;
    }

    @Override
    protected FilePojo uploadFileSharding(MultipartFile file, HttpSession session) {
        System.out.println("20:25 2022/3/11 OssService uploadFileSharding" );
        return null;
    }


    @Override
    protected void deleteFile(String url) {
        ossTemplate.delete(url);
    }

    @Override
    public void download(String url, HttpServletResponse response) {
        System.out.println("20:25 2022/3/11 OssService download" );
    }

}
