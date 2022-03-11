package com.free.fs.service.impl;

import com.free.fs.model.FilePojo;
import com.free.fs.service.FileService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : wuxiao
 * @date : 19:24 2022/3/11
 */
public abstract class AbstractIFileService implements FileService {

    /**
     * 上传文件
     *
     * @param file
     */
    protected abstract FilePojo uploadFile(MultipartFile file);

    @Override
    public boolean delete(String url) {
        deleteFile( url);
        return false;
    }
    /**
     * 删除文件资源
     *
     * @param url 文件路径
     */
    protected abstract void deleteFile(String url);
}
