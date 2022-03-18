package com.free.fs.controller;

import com.free.fs.common.util.R;
import com.free.fs.model.FilePojo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : wuxiao
 * @date : 9:42 2022/3/17
 */
@Api()
@ApiSort(1)
public interface FileControllerSwagger {
    /***
     * 对象存储方式切换测试
     * @return
     */

    @ApiOperation("对象存储方式切换测试")
    @ApiOperationSupport(order=15)
    public R switchingStorageMode();

    /**
     * 新增文件夹
     *
     * @param pojo
     */
    @ApiOperation("新增文件夹")
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({//allowableValues="不要特殊字符"
            @ApiImplicitParam(name="dirIds",value="目录 例:/ 或者/8/9",paramType = "query",required=true,dataTypeClass = String.class),
            @ApiImplicitParam(name="name",value="文件名称 例:其他",paramType = "query",required=true,dataTypeClass = String.class),
    })
    public R addFolder(FilePojo pojo) ;


    /**
     * 根据id删除文件
     * @param id
     */
    @ApiOperationSupport(order = 9)
    @ApiImplicitParams({//allowableValues="不要特殊字符"
            @ApiImplicitParam(name="id",value="数据库ID 例:1 或者13",paramType = "query",required=true,dataTypeClass = Long.class),
    })
    @ApiOperation("根据id删除文件")
    public R deleteByIds(Long id) ;

    /**
     * 根据url删除文件
     * @param url
     */
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams({//allowableValues="不要特殊字符"
            @ApiImplicitParam(name="url",value="文件或图片的url 例:http://host/25c7c076d.png ",paramType = "query",required=true,dataTypeClass = String.class),
    })
    @ApiOperation("根据url删除文件")
    public R deleteFile(String url) ;

    /**
     * 移动文件
     *
     * @param ids
     * @param parentId
     */
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name="ids",value="源文件ID 例:\"38,34,46\"",paramType = "query",required=true,dataTypeClass = String.class),
            @ApiImplicitParam(name="parentId",value="目标路径ID 37",paramType = "query",required=true,dataTypeClass = Long.class),
    })
    @ApiOperation("移动文件")
    public R move(String ids, Long parentId) ;


    /**
     * 修改名称
     *
     * @param pojo
     */
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="数据库ID 例:2 或者40",paramType = "query",required=true,dataTypeClass = Long.class),
            @ApiImplicitParam(name="name",value="旧文件名 ",paramType = "query",required=true,dataTypeClass = String.class),
            @ApiImplicitParam(name="rename",value="新文件名 ",paramType = "query",required=true,dataTypeClass = String.class),
    })
    @ApiOperation("修改名称")
    public R upload(FilePojo pojo);


    /**
     * 文件下载
     *
     * @param url
     * @param response
     * 参考 https://gitee.com/xiaoym/knife4j/issues/I1F40F#note_2519831_link
     */
    @ApiOperationSupport(order = 10)
    @ApiOperation("文件下载")
    public void downLoad(String url, HttpServletResponse response) ;



    /**
     * 文件分片上传
     * @param files
     * @return
     */
    @ApiOperationSupport(order = 11)
    @ApiOperation("文件分片上传")
    public R uploadSharding(@RequestParam(value = "file") MultipartFile[] files, String dirIds, HttpServletRequest request) ;



    /**
     * 获取进度数据
     *
     * @param request
     * @return
     */
    @ApiOperationSupport(order = 12)
    @ApiOperation("获取进度数据")
    public Integer percent(HttpServletRequest request) ;
    /**
     * 重置上传进度
     *
     * @param request
     */
    @ApiOperationSupport(order = 13)
    @ApiOperation("重置上传进度")
    public void resetPercent(HttpServletRequest request) ;


    /**
     * 获取目录列表
     *
     * @param id
     * @return
     */
    @ApiOperationSupport(order = 4)
    @ApiOperation("获取目录列表")
    public R getDirs(Long id);

    /**
     * 获取文件列表 /35/38
     *
     * @param pojo
     * @return
     */
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
            @ApiImplicitParam(name="dirIds",value="文件夹路径 例:/35/38",paramType = "query",required=true,dataTypeClass = String.class),
    })
    @ApiOperation("获取文件列表")
    public R getList(FilePojo pojo) ;

    /**
     * 获取树结构列表
     *
     * @param pojo
     * @return
     */
    @ApiOperationSupport(order = 6)
    @ApiOperation("获取树结构列表" )
    public String getTree(FilePojo pojo) ;

    /**
     * 获取树结构目录列表
     *
     * @param pojo
     * @return
     */
    @ApiOperationSupport(order = 7)
    @ApiOperation("获取树结构目录列表")
    public String getDirTree(FilePojo pojo) ;

}
