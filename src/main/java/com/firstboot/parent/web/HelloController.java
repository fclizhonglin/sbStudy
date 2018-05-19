package com.firstboot.parent.web;

import com.firstboot.parent.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiong on 2018/5/3.
 */
@Controller
public class HelloController {

//    @RequestMapping("/hello")
//    public String index(){
//        return "hello";
//    }

    @RequestMapping("/")
    public String index(ModelMap map){
        //加入一个用来在模板中读取的属性
        map.addAttribute("host","http://blog.studyspace.com");
        //return模板名称，对应src/main/resources/templates/index.html
        return "index";
    }


    @RequestMapping("/hello")
    public String hello() throws Exception{
         throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws MyException{
        throw new MyException("发生错误2");
    }

}
