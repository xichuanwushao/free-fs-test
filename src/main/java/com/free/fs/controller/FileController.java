package com.free.fs.controller;

import com.free.fs.common.util.R;
import com.free.fs.model.FilePojo;
import com.free.fs.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author : wuxiao
 * @date : 19:18 2022/3/11
 */
@RestController
@RequestMapping("file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;
    /**
     * 获取文件列表
     * @return
     */
    @GetMapping({ "/list"})
    public String getList() {
        return "查询成功";
    }


    @GetMapping("/deleteFileTest")
    public R deleteFileTest(String url) {
        if (fileService.delete(url)) {
            return R.succeed("删除成功");
        }
        return R.failed("删除失败");

    }
    /**
     * 新增文件夹
     *
     * @param pojo
     */
    @PostMapping("/addFolder")
    public R addFolder(FilePojo pojo) {
        fileService.addFolder(pojo);
        return R.succeed("添加成功");
    }
    /**
     * 根据id删除文件
     *
     * @param id
     */
    @PostMapping("/deleteByIds")
    public R deleteByIds(Long id) {
        fileService.deleteByIds(id);
        return R.succeed("删除成功");

    }


    /**
     * 根据url删除文件
     *
     * @param url
     */
    @PostMapping("/deleteFile")
    public R deleteFile(String url) {
        fileService.delete(url);
        return R.succeed("删除成功");
    }


    /**
     * 移动文件
     *
     * @param ids
     * @param parentId
     */
    @PostMapping("/move")
    public R move(String ids, Long parentId) {
        fileService.move(ids, parentId);
        return R.succeed("移动成功");
    }

    /**
     * 修改名称
     *
     * @param pojo
     */
    @PostMapping("/updateByName")
    public R upload(FilePojo pojo) {
        fileService.updateByName(pojo);
        return R.succeed("修改成功");

    }
    /**
     * 文件下载
     *
     * @param url
     * @param response
     */
    @GetMapping("/downLoad")
    public void downLoad(String url, HttpServletResponse response) {
        fileService.download(url, response);
    }
}
