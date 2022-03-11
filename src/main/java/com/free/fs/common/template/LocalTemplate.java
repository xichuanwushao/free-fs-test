package com.free.fs.common.template;

import com.free.fs.common.properties.FsServerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author : wuxiao
 * @date : 20:25 2022/3/11
 */
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "local")
public class LocalTemplate {
    @Resource
    private FsServerProperties fileProperties;

    public void delete(String url) {
        String upload = fileProperties.getLocal().getUploadPath() ;
        System.out.println("20:25 2022/3/11 LocalTemplate delete" +upload);
    }
}
