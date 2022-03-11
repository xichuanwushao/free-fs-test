package com.free.fs.common.template;

import com.free.fs.common.properties.FsServerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.annotation.Resource;

/**
 * @author : wuxiao
 * @date : 20:25 2022/3/11
 */
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "local")
public class LocalTemplate {


}
