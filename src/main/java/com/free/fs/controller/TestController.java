package com.free.fs.controller;

import com.free.fs.common.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
@Api
public class TestController {

    @GetMapping("/sayHello")
    @ApiOperation("sayHello测试方法")
    public R sayHello(){
        return R.succeed("message","hello world 5 ");
    }

    @PostMapping("/sayHello2")
    @ApiOperation("sayHello测试方法")
    public R sayHello2( String req){
        return R.succeed("message", "Hello, ");
    }

    @GetMapping("/registerUser")
    @ApiOperation("测试方法")
    public R registerUser(){
        return R.succeed("message","hello world 5 ");
    }
    @GetMapping("/searchUserPermissions")
    @ApiOperation("测试方法")
    public R searchUserPermissions(int id){
        return R.succeed("message","searchUserPermissions");
    }


    @PostMapping("/addUser")
    @ApiOperation("添加用户测试用户权限")
    public R addUser(){
        return R.succeed("用户添加成功");
    }


}
