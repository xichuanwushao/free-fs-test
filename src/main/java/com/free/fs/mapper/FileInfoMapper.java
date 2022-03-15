package com.free.fs.mapper;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.free.fs.model.FilePojo;

import java.util.List;

/**
 * <p>
 * 文件资源表 Mapper 接口
 * </p>
 *
 * @author wuxiao
 * @since 2022-03-14
 */
public interface FileInfoMapper extends BaseMapper<FilePojo> {
    /**
     * 根据id查询它所有上级（包含自身）
     *
     * @param id 根节点
     * @return
     */
    @SqlParser(filter = true)
    List<FilePojo> selectParentList(Long id);

}
