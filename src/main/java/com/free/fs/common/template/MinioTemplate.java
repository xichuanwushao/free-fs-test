package com.free.fs.common.template;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * @author : wuxiao
 * @date : 20:40 2022/3/11
 */
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "minio")
public class MinioTemplate {
}
