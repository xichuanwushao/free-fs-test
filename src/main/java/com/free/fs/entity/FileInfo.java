package com.free.fs.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.io.Serializable;
/**
 * <p>
 * 文件资源表
 * </p>
 *
 * @author wuxiao
 * @since 2022-03-14
 */
@Data
@TableName("file_info")
@EqualsAndHashCode(callSuper = true)
public class FileInfo extends Model<FileInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 资源原始名称
     */
    private String name;

    /**
     * 资源名称
     */
    private String fileName;

    /**
     * 后缀名
     */
    private String suffix;

    /**
     * 是否图片
     */
    private Boolean isImg;

    /**
     * 尺寸
     */
    private Integer size;

    /**
     * 文件展示类型，非后缀名
     */
    private String type;

    /**
     * 上传时间
     */
    private LocalDateTime putTime;

    /**
     * 是否目录
     */
    private Boolean isDir;

    private Integer parentId;

    /**
     * 来源
     */
    private String source;


}
