package com.free.fs.service.impl;

import com.free.fs.common.util.R;
import com.free.fs.model.FilePojo;
import com.free.fs.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : wuxiao
 * @date : 19:24 2022/3/11
 */
public abstract class AbstractIFileService implements FileService {


    @Override
    public boolean delete(String url) {
        deleteFile( url);
        return false;
    }
    /**
     * 删除文件资源
     *
     * @param url 文件路径
     */
    protected abstract void deleteFile(String url);




    @Override
    public boolean addFolder(FilePojo pojo) {
        System.out.println(" AbstractIFileService addFolder 调用了新增文件夹");
        return false;
    }

    @Override
    public boolean deleteByIds(Long id){
        System.out.println(" AbstractIFileService addFolder 调用了删除文件夹");
        return false;
    }

    @Override
    public boolean move(String ids, Long parentId) {
        System.out.println(" AbstractIFileService move 调用了移动文件");
        return true;
    }
    @Override
    public boolean updateByName(FilePojo pojo) {
        System.out.println(" AbstractIFileService updateByName 调用了重命名");
        return true;
    }
    @Override
    public R upload(MultipartFile[] files, String dirIds){
        for (MultipartFile file : files) {
            FilePojo filePojo = uploadFile(file);
        }
        return null;
    }
    /**
     * 上传文件
     *
     * @param file
     */
    protected abstract FilePojo uploadFile(MultipartFile file);

    @Override
    public R uploadSharding(MultipartFile[] files, String dirIds, HttpSession session) {

        for (MultipartFile file : files) {
            FilePojo filePojo = uploadFileSharding(file, session);
        }
        return R.succeed("上传成功");
    }

    protected abstract FilePojo uploadFileSharding(MultipartFile file, HttpSession session);

}
