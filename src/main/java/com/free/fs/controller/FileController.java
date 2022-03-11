package com.free.fs.controller;

import com.free.fs.common.util.R;
import com.free.fs.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("/deleteFile")
    public R deleteFile(String url) {
        if (fileService.delete(url)) {
            return R.succeed("删除成功");
        }
        return R.failed("删除失败");

    }
}
