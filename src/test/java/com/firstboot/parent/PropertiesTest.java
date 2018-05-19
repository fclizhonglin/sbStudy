package com.firstboot.parent;

import com.firstboot.parent.service.StudyProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xiong on 2018/5/3.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Autowired
    private StudyProperties studyProperties;

    @Test
    public void getHello()throws Exception{
        Assert.assertEquals(studyProperties.getName(),"程序员大哥");
        Assert.assertEquals(studyProperties.getTitle(),"Spring Boot练习");
        System.out.println("我的文章描述为："+studyProperties.getDesc());
        System.out.println("value:"+studyProperties.getValue());
        System.out.println("number:"+studyProperties.getNumber());
        System.out.println("bignumber:"+studyProperties.getBignumber());
        System.out.println("test1:"+studyProperties.getTest1());
        System.out.println("test2:"+studyProperties.getTest2());
//        System.out.println("profile:"+studyProperties.getPro());
    }


}
