package com.firstboot.parent;

import com.firstboot.parent.service.UserService;
import com.sun.glass.ui.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xiong on 2018/5/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest2 {

    @Autowired
    private UserService userService;

    @Before
    public void setUp(){
        //清空user表
        userService.deleteAllUsers();
    }

    @Test
    public void test()throws Exception{
        //插入3个用户
        userService.create("jak",1);
        userService.create("kak",2);
        userService.create("wak",3);
        userService.create("rak",4);
        userService.create("yak",5);

        //查询数据库应该有5个用户
        Assert.assertEquals(5,userService.getAllUsers().intValue());

        //删除两个用户
        userService.deleteByName("jak");
        userService.deleteByName("wak");

        //查询数据库应该有3个用户
        Assert.assertEquals(3,userService.getAllUsers().intValue());

    }

}
