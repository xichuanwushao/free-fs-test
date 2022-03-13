package com.free.fs.common.template;

import com.free.fs.common.properties.FsServerProperties;
import com.free.fs.model.FilePojo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author : wuxiao
 * @date : 20:40 2022/3/11
 */
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "minio")
@Component
public class MinioTemplate {
    @Resource
    private FsServerProperties fileProperties;

    public void delete(String url) {
        String key = fileProperties.getMinio().getAccessKey() ;
        System.out.println("20:25 2022/3/11 MinioTemplate delete" +key);
        System.out.println("还未实现！delete");
    }

    public FilePojo upload(MultipartFile file) {
        System.out.println("还未实现！upload");
        return null;
    }

    public FilePojo uploadSharding(MultipartFile file, HttpSession session) {
        System.out.println("还未实现！uploadSharding");
        return null;
    }

    public void download(String url, HttpServletResponse response) {
        System.out.println("还未实现！download");
    }
}
