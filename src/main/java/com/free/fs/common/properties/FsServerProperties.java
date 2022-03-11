package com.free.fs.common.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : wuxiao
 * @date : 20:26 2022/3/11
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "fs.files-server")
public class FsServerProperties {
    /**
     * 自动化配置
     * type：oss or local or minio
     */
    private String type = "oss";

    /**
     * 本地上传配置
     */
    LocalProperties local = new LocalProperties();

    /**
     * minio配置
     */
    MinioProperties minio = new MinioProperties();

    /**
     * oss配置
     */
    OssProperties oss = new OssProperties();
}
