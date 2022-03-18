package com.free.fs.common.template;

import cn.hutool.core.io.StreamProgress;
import com.free.fs.common.minio.MinioClientBuilder;
import com.free.fs.common.properties.FsServerProperties;
import com.free.fs.common.util.FileUtil;
import com.free.fs.model.FilePojo;
import com.free.fs.common.util.MinioUtils;
import io.minio.MinioClient;
import io.minio.ObjectStat;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author : wangjun
 * @date : 12:14 2022/3/16
 */
@ConditionalOnProperty(prefix = "fs.files-server", name = "type", havingValue = "minio")
@Component
public class MinioTemplate {
    @Resource
    private FsServerProperties fileProperties;


    @SneakyThrows
    public boolean delete(String objectName) {
        MinioClient minioClient = new MinioClientBuilder().build(
                fileProperties.getMinio().getConsoleUrl(),
                fileProperties.getMinio().getApiPort(),
                fileProperties.getMinio().getAccessKey(),
                fileProperties.getMinio().getSecretKey(),false
        );
        Boolean isDeleteObject = MinioUtils.getInstance().deleteObject(minioClient,fileProperties.getMinio().getDefaultBucket(), objectName);
        return isDeleteObject;
    }
    @SneakyThrows
    public FilePojo upload(MultipartFile file) {
        MinioClient minioClient = new MinioClientBuilder().build(
                fileProperties.getMinio().getConsoleUrl(),
                fileProperties.getMinio().getApiPort(),
                fileProperties.getMinio().getAccessKey(),
                fileProperties.getMinio().getSecretKey(),false
        );
        FilePojo pojo = FileUtil.buildFilePojo(file);
        if (uploadObject(minioClient,file,pojo)) {
            pojo.setUrl(getObjectUrl(file,pojo));
        }
        return pojo;
    }

    public FilePojo uploadSharding(MultipartFile file, HttpSession session) {
        System.out.println("还未实现！ uploadSharding" );
        return null;
    }

    public void download(String objectName, HttpServletResponse response) {
        try {
            MinioClient minioClient = new MinioClientBuilder().build(
                    fileProperties.getMinio().getConsoleUrl(),
                    fileProperties.getMinio().getApiPort(),
                    fileProperties.getMinio().getAccessKey(),
                    fileProperties.getMinio().getSecretKey(),false
            );
            ObjectStat objectStat = MinioUtils.getInstance().statObject(minioClient,fileProperties.getMinio().getDefaultBucket(), objectName);
            long totalLength = objectStat.length();
            MinioUtils.getInstance().downloadObject(minioClient,fileProperties.getMinio().getDefaultBucket(), objectName, response.getOutputStream(), 10240, new StreamProgress() {
                @Override
                public void start() {
                    System.out.println("*****start*****");
                }

                @Override
                public void progress(long readLength) {
                    long rate = readLength * 100 / totalLength;
                    System.out.println(rate);
                }

                @Override
                public void finish() {
                    System.out.println("*****finish*****");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void download(String objectName, OutputStream outputStream) {
        try {
            MinioClient minioClient = new MinioClientBuilder().build(
                    fileProperties.getMinio().getConsoleUrl(),
                    fileProperties.getMinio().getApiPort(),
                    fileProperties.getMinio().getAccessKey(),
                    fileProperties.getMinio().getSecretKey(),false
            );
            ObjectStat objectStat = MinioUtils.getInstance().statObject(minioClient,fileProperties.getMinio().getDefaultBucket(), objectName);
            long totalLength = objectStat.length();
            MinioUtils.getInstance().downloadObject(minioClient,fileProperties.getMinio().getDefaultBucket(), objectName, outputStream, 10240, new StreamProgress() {
                @Override
                public void start() {
                    System.out.println("*****start*****");
                }

                @Override
                public void progress(long readLength) {
                    long rate = readLength * 100 / totalLength;
                    System.out.println(rate);
                }

                @Override
                public void finish() {
                    System.out.println("*****finish*****");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean uploadObject( MinioClient minioClient,MultipartFile file, FilePojo pojo) {
        boolean isUpload = false;
        String contentType = FileUtil.getcontentType(pojo.getFileName().substring(pojo.getFileName().lastIndexOf(".")));
        long partLength = 1024 * 1024 *5;   //5M
        try {
            InputStream inputStream = file.getInputStream();
            isUpload = MinioUtils.getInstance().uploadFile(minioClient,fileProperties.getMinio().getDefaultBucket(), pojo.getFileName(), inputStream, pojo.getSize(), partLength,contentType);
            // 关闭流
            inputStream.close();
        } catch (Exception e) {
            isUpload = false;
            e.printStackTrace();
        }
        return isUpload;
    }
    @SneakyThrows
    public String getObjectUrl(MultipartFile file,FilePojo pojo) {
        MinioClient minioClient = new MinioClientBuilder().build(
                fileProperties.getMinio().getConsoleUrl(),
                fileProperties.getMinio().getApiPort(),
                fileProperties.getMinio().getAccessKey(),
                fileProperties.getMinio().getSecretKey(),false
        );
        String objectUrl = MinioUtils.getInstance().getPresignedObjectUrl(minioClient,fileProperties.getMinio().getDefaultBucket(), pojo.getFileName(), 3600);
        System.out.println("对象的外链URL=="+objectUrl);
        return objectUrl;
    }


}
