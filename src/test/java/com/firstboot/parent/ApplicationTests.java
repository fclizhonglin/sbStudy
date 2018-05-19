package com.firstboot.parent;

import com.firstboot.parent.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by xiong on 2018/5/3.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockServletContext.class)
public class ApplicationTests {

    private MockMvc mvc;

    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController()throws Exception{
    //测试userController
        RequestBuilder request = null;

        //1、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

        //2、post提交一个user
        request=post("/users/").param("id","1").param("name","驱动大师").param("age","20");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        //3、查询试一下
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"驱动大师\",\"age\":20}]")));

        //4、put修改id为1的user
        request=put("/users/1").param("name","终极驱动大师").param("age","18");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        //5、get一个id为1的user
        request=get("/users/1");
        mvc.perform(request).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"终极驱动大师\",\"age\":18}")));

        //6、删除id为1的user
        request=delete("/users/1");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        //7、查一下users
        request=get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

    }

}
