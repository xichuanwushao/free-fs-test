package com.free.fs.service.impl;

import com.free.fs.common.template.LocalTemplate;
import com.free.fs.model.FilePojo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
    protected FilePojo uploadFile(MultipartFile file) {
        System.out.println("@date : 19:28 2022/3/11 uploadFile");
        return null;
    }

    @Override
    protected void deleteFile(String url) {
        localTemplate.delete(url);
    }


    @Override
    public void download(String url, HttpServletResponse response) {
        localTemplate.download(url, response);
    }

}
