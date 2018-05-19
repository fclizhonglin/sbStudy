package com.firstboot.parent;

import com.firstboot.parent.model.User;
import com.firstboot.parent.model.UserRepository;
import org.junit.Assert;
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
public class JpaTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test()throws Exception{

        //创建10条记录
        userRepository.save(new User("AAA",10));
        userRepository.save(new User("BBB",11));
        userRepository.save(new User("CCC",12));
        userRepository.save(new User("DDD",13));
        userRepository.save(new User("EEE",14));
        userRepository.save(new User("FFF",15));
        userRepository.save(new User("GGG",16));
        userRepository.save(new User("HHH",17));
        userRepository.save(new User("III",18));
        userRepository.save(new User("JJJ",19));


        //测试是否有109条
        Assert.assertEquals(10,userRepository.count());
        //测试FFF是否15岁
        Assert.assertEquals(15,userRepository.findByName("FFF").getAge());
        //测试findUser方法
        Assert.assertEquals("EEE",userRepository.findUser("EEE").getName());
        //测试删除姓名为AAA的user
        userRepository.delete(userRepository.findByName("AAA"));
        Assert.assertEquals(9,userRepository.count());


    }

}
