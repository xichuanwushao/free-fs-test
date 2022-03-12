package com.free.fs.common.template;

import com.free.fs.common.properties.FsServerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : wuxiao
 * @date : 20:25 2022/3/11
 */
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "local")
@Component
public class LocalTemplate {
    @Resource
    private FsServerProperties fileProperties;

    public void delete(String url) {
        String delete = fileProperties.getLocal().getUploadPath() ;
        System.out.println("20:25 2022/3/11 LocalTemplate delete" +delete);
    }

    public void download(String url, HttpServletResponse response) {
        System.out.println("20:25 2022/3/11 LocalTemplate download" );
    }
}
