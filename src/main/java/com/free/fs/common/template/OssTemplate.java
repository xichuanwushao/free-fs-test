package com.free.fs.common.template;

import com.free.fs.common.properties.FsServerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : wuxiao
 * @date : 20:40 2022/3/11
 */
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "oss")
@Component
public class OssTemplate {

    @Resource
    private FsServerProperties fileProperties;

    public void delete(String url) {
        String key = fileProperties.getOss().getAccessKey() ;
        System.out.println("20:25 2022/3/11 OssTemplate delete" +key);
    }
}
