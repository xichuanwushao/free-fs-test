package com.free.fs.service;

import com.free.fs.common.util.R;
import com.free.fs.model.FilePojo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author : wuxiao
 * @date : 19:20 2022/3/11
 */
public interface FileService {

    /**
     * 删除文件
     *
     * @param url
     * @return
     */
    boolean delete(String url);
}
