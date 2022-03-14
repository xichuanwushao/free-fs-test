package com.free.fs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.free.fs.common.constant.CommonConstant;
import com.free.fs.common.exception.BusinessException;
import com.free.fs.common.util.R;
import com.free.fs.mapper.FileInfoMapper;
import com.free.fs.model.FilePojo;
import com.free.fs.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : wuxiao
 * @date : 19:24 2022/3/11
 */
public abstract class AbstractIFileService extends ServiceImpl<FileInfoMapper, FilePojo> implements FileService {


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




    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addFolder(FilePojo pojo) {
        String dirId = pojo.getDirIds().substring(pojo.getDirIds().lastIndexOf(CommonConstant.DIR_SPLIT) + 1);
        if (CommonConstant.DIR_SPLIT.equals(dirId) || StringUtils.isEmpty(dirId)) {
            pojo.setParentId(CommonConstant.ROOT_PARENT_ID);
        } else {
            FilePojo p = baseMapper.selectById(Long.parseLong(dirId));
            pojo.setParentId(p.getId());
        }
        pojo.setType(CommonConstant.DEFAULT_DIR_TYPE);
        pojo.setIsDir(Boolean.TRUE);
        pojo.setIsImg(Boolean.FALSE);
        //判断文件夹名称在当前目录中是否存在
        Integer count = baseMapper.selectCount(
                new LambdaQueryWrapper<FilePojo>()
                        .eq(FilePojo::getName,pojo.getName())
                        .eq(FilePojo::getIsDir,Boolean.TRUE)
                        .eq(FilePojo::getParentId,pojo.getParentId())
        );
        if (count > 0) {
            throw new BusinessException("当前目录名称已存在，请修改后重试！");
        }
        return baseMapper.insert(pojo) > 0;
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

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateByName(FilePojo pojo) {
        if (pojo.getName().equals(pojo.getRename())) {
            throw new BusinessException("当前名称与原始名称相同，请修改后重试！");
        }
        FilePojo p = baseMapper.selectById(pojo.getId());
        //判断文件夹名称在当前目录中是否存在
        Integer count = baseMapper.selectCount(
                new LambdaQueryWrapper<FilePojo>()
                        .eq(FilePojo::getName, pojo.getRename())
                        .eq(FilePojo::getIsDir,p.getIsDir())
                        .eq(FilePojo::getParentId,p.getParentId())
        );
        if (count > 0) {
            throw new BusinessException("当前目录已存在该名称,请修改后重试！");
        }
        FilePojo updPojo = new FilePojo();
        updPojo.setId(pojo.getId());
        updPojo.setName(pojo.getRename());
        return baseMapper.updateById(updPojo) > 0;
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


    @Override
    public Map<String, Object> getDirs(Long id) {
        System.out.println(" AbstractIFileService getDirs 调用了getDirs");
        return null;
    }


    @Override
    public List<FilePojo> getList(FilePojo pojo) {
        System.out.println(" AbstractIFileService getList 调用了getList");
        return null;
    }
}
