package com.free.fs.controller;

import com.alibaba.fastjson.JSON;
import com.free.fs.common.util.R;
import com.free.fs.model.Dtree;
import com.free.fs.model.FilePojo;
import com.free.fs.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author : wuxiao
 * @date : 19:18 2022/3/11
 */
@Api
@RestController
@RequestMapping("file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;


    /***
     * 对象存储方式切换测试
     * @return
     */
    @ApiOperation("对象存储方式切换测试")
    @GetMapping("/switchingStorage")
    public R switchingStorageMode() {
        return R.succeed(fileService.switchingStorageMode());
    }
    /**
     * 新增文件夹
     *
     * @param pojo
     */
    @ApiImplicitParams({//allowableValues="不要特殊字符"
            @ApiImplicitParam(name="dirIds",value="目录 例:/ 或者/8/9",paramType = "query",required=true,dataTypeClass = String.class),
            @ApiImplicitParam(name="name",value="文件名称 例:其他",paramType = "query",required=true,dataTypeClass = String.class),
    })
    @ApiOperation("新增文件夹")
    @PostMapping("/addFolder")
    public R addFolder(FilePojo pojo) {
        if (fileService.addFolder(pojo)) {
            return R.succeed("添加成功");
        }
        return R.failed("添加失败");
    }
    /**
     * 根据id删除文件
     * @param id
     */
    @ApiOperation("根据id删除文件")
    @PostMapping("/deleteByIds")
    public R deleteByIds(Long id) {
        if (fileService.deleteByIds(id)) {
            return R.succeed("删除成功");
        }
        return R.failed("删除失败");

    }


    /**
     * 根据url删除文件
     *
     * @param url
     */
    @ApiOperation("根据url删除文件")
    @PostMapping("/deleteFile")
    public R deleteFile(String url) {
        if (fileService.delete(url)) {
            return R.succeed("删除成功");
        }
        return R.failed("删除失败");
    }


    /**
     * 移动文件
     *
     * @param ids
     * @param parentId
     */
    @ApiOperation("移动文件")
    @PostMapping("/move")
    public R move(String ids, Long parentId) {
        if (fileService.move(ids, parentId)) {
            return R.succeed("移动成功");
        }
        return R.failed("移动失败");
    }

    /**
     * 修改名称
     *
     * @param pojo
     */
    @ApiOperation("修改名称")
    @PostMapping("/updateByName")
    public R upload(FilePojo pojo) {
        if (fileService.updateByName(pojo)) {
            return R.succeed("修改成功");
        }
        return R.failed("修改失败");

    }
    /**
     * 文件下载
     *
     * @param url
     * @param response
     * 参考 https://gitee.com/xiaoym/knife4j/issues/I1F40F#note_2519831_link
     */
    @ApiOperation("文件下载")
    @GetMapping(value="/downLoad",produces = "application/octet-stream")
    public void downLoad(String url, HttpServletResponse response) {
        fileService.download(url, response);
    }



    /**
    *文件上传
    *@param files
    *@param dirIds
    *@return
    */
    @ApiOperation("文件上传")
    @ApiImplicitParams({
    @ApiImplicitParam(name="files",value="文件流对象,接收数组格式",required=true,dataType="java.io.File",paramType="query"),
    @ApiImplicitParam(name="dirIds",value="目录盘符",required=true,dataTypeClass = String.class)
    })
    @PostMapping({"/upload"})
    public R upload(@RequestPart(value="files")MultipartFile[] files,String dirIds){
        return fileService.upload(files,dirIds);
    }

    /**
     * 文件分片上传
     * @param files
     * @return
     */
    @ApiOperation("文件分片上传")
    @PostMapping("/uploadSharding")
    public R uploadSharding(@RequestParam(value = "file") MultipartFile[] files, String dirIds, HttpServletRequest request) {
        return fileService.uploadSharding(files, dirIds, request.getSession());
    }

    /**
     * 获取进度数据
     *
     * @param request
     * @return
     */
    @ApiOperation("获取进度数据")
    @GetMapping("/percent")
    public Integer percent(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (session.getAttribute("uploadPercent") == null ? 0 : (Integer) session.getAttribute("uploadPercent"));
    }

    /**
     * 重置上传进度
     *
     * @param request
     */
    @ApiOperation("重置上传进度")
    @GetMapping("/percent/reset")
    public void resetPercent(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("uploadPercent", 0);
    }


    /**
     * 获取目录列表
     *
     * @param id
     * @return
     */
    @ApiOperation("获取目录列表")
    @GetMapping("/getDirs")
    public R getDirs(Long id) {
        Map<String, Object> map = fileService.getDirs(id);
        return R.succeed(map, "查询成功!");
    }

    /**
     * 获取文件列表
     *
     * @param pojo
     * @return
     */
    @ApiOperation("获取文件列表")
    @GetMapping({"", "/list"})
    public R getList(FilePojo pojo) {
        List<FilePojo> list = fileService.getList(pojo);
        return R.succeed(list, "查询成功!");
    }

    /**
     * 获取树结构列表
     *
     * @param pojo
     * @return
     */
    @ApiOperation("获取树结构列表")
    @GetMapping("/getTree")
    public String getTree(FilePojo pojo) {
        List<Dtree> list = fileService.getTreeList(pojo);
        return JSON.toJSONString(R.succeed(list, "查询成功"));
    }


    /**
     * 获取树结构目录列表
     *
     * @param pojo
     * @return
     */
    @ApiOperation("获取树结构目录列表")
    @GetMapping("/getDirTree")
    public String getDirTree(FilePojo pojo) {
        List<Dtree> list = fileService.getDirTreeList(pojo);
        return JSON.toJSONString(R.succeed(list, "查询成功"));
    }
}
