package com.free.fs.service.impl;

import com.free.fs.model.FilePojo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : wuxiao
 * @date : 19:28 2022/3/11
 */
@Service
public class LocalService extends AbstractIFileService{
    @Override
    protected FilePojo uploadFile(MultipartFile file) {
        return null;
    }
}
