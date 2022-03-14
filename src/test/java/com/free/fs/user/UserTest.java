package com.free.fs.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.free.fs.FreeFsTestApplicationTests;
import com.free.fs.entity.MoocBackendUserT;
import com.free.fs.mapper.MoocBackendUserTMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : wuxiao
 * @date : 15:44 2022/3/13
 */
public class UserTest extends FreeFsTestApplicationTests {
    @Resource
    private MoocBackendUserTMapper moocBackendUserTMapper;
    @Test
    public void add1(){
        System.out.println("ww");
    }
    @Test
    public void add(){
        try {
            for (int i = 0; i < 6; i++) {
                MoocBackendUserT user = new MoocBackendUserT();
                user.setUserName("zhangsan" + i);
                user.setUserPwd("qwe123" + i);
                user.setUserPhone("899-2123-1323" + i);
                moocBackendUserTMapper.insert(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Test
    public void delete(){
        moocBackendUserTMapper.deleteById(2);
    }
    @Test
    public void update(){
        MoocBackendUserT user = new MoocBackendUserT();
        user.setUuid(2);
        user.setUserName("admin");
        user.setUserPwd("admin123");
        user.setUserPhone("899-2123-1323");
        moocBackendUserTMapper.updateById(user);

    }
    @Test
    public void select(){
        MoocBackendUserT moocBackendUserT = moocBackendUserTMapper.selectById("2");
        System.out.println(moocBackendUserT);
        List<MoocBackendUserT> moocBackendUserTS = moocBackendUserTMapper.selectList(null);
        moocBackendUserTS.stream().forEach(
            System.out::println
        );

    }

    @Test
    public void selectTall(){
        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("user_name","zhangsan2");
        queryWrapper.like("user_name","zhangsan");
        List<MoocBackendUserT> moocBackendUserTS = moocBackendUserTMapper.selectList(queryWrapper);
        moocBackendUserTS.stream().forEach(
                System.out::println
        );
    }

    @Test
    public void updateTall(){

        MoocBackendUserT user2 = new MoocBackendUserT();
        user2.setUserName("zhangsan8");
        user2.setUserPwd("admin123");
        user2.setUserPhone("899-2123-1323");

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name","zhangsan5");
        moocBackendUserTMapper.update(user2,queryWrapper);
    }

    @Test
    public void selectPage(){
        //分页对象
        Page<MoocBackendUserT> page = new Page<MoocBackendUserT>(1,3);
        //条件
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("user_name","zhangsan");

        IPage<MoocBackendUserT> iPage = moocBackendUserTMapper.selectPage(page, queryWrapper);
        iPage.getRecords().stream().forEach(
                System.out::println
        );

    }
}
