package com.firstboot.parent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xiong on 2018/6/4.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleDataSourceTest {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Before
    public void setUp(){
        jdbcTemplate1.update("DELETE FROM USER");
        jdbcTemplate2.update("DELETE FROM USER");
    }

    @Test
    public void test() throws Exception{
        //往第一个数据源中插入数据
        jdbcTemplate1.update("insert into user(id,name,age) values(?,?,?)",1,"aaa",20);
        jdbcTemplate1.update("insert into user(id,name,age) values(?,?,?)",2,"bbb",19);
        //往第二个数据源中插入数据
        jdbcTemplate2.update("insert into user(id,name,age) values(?,?,?)",1,"aaa",20);
        //检测表yi中是否有两条数据
        Assert.assertEquals("2",jdbcTemplate1.queryForObject("select count(1) from user",String.class));
        Assert.assertEquals("1",jdbcTemplate2.queryForObject("select count(1) from user",String.class));
    }

}
