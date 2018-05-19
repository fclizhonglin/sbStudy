package com.firstboot.parent.service;

/**
 * Created by xiong on 2018/5/17.
 */

public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name,Integer age);

    /**
     * 通过名字删除用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     * @return
     */
    Integer getAllUsers();


    /**
     * 删除所有用户
     */
    void deleteAllUsers();

}
