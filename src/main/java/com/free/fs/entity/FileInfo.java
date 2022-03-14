package com.free.fs.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Boolean getImg() {
        return isImg;
    }

    public void setImg(Boolean isImg) {
        this.isImg = isImg;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getPutTime() {
        return putTime;
    }

    public void setPutTime(LocalDateTime putTime) {
        this.putTime = putTime;
    }

    public Boolean getDir() {
        return isDir;
    }

    public void setDir(Boolean isDir) {
        this.isDir = isDir;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
        ", id=" + id +
        ", url=" + url +
        ", name=" + name +
        ", fileName=" + fileName +
        ", suffix=" + suffix +
        ", isImg=" + isImg +
        ", size=" + size +
        ", type=" + type +
        ", putTime=" + putTime +
        ", isDir=" + isDir +
        ", parentId=" + parentId +
        ", source=" + source +
        "}";
    }
}
