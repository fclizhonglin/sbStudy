package com.firstboot.parent.web;

import com.firstboot.parent.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by xiong on 2018/5/3.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    //创建线程安全的map
    static Map<Integer,User> users =  Collections.synchronizedMap(new HashMap());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){
        //处理get请求用于获取user
        List<User> r = new ArrayList<User>(UserController.users.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        //处理"/users/"的post请求，用来创建user
        users.put(user.getId(),user);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id){
        return users.get(id);
    }


    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id){
        users.remove(id);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "path")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable Integer id,@ModelAttribute User user){
        //处理put请求,用来更新User信息
        User u= users.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        users.put(id,u);
        return "success";
    }

}
