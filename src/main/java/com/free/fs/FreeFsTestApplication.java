package com.free.fs;

import com.free.fs.common.properties.FsServerProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FsServerProperties.class)
public class FreeFsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreeFsTestApplication.class, args);
    }

}
