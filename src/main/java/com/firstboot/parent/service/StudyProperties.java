package com.firstboot.parent.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by xiong on 2018/5/3.
 */

@Component
public class StudyProperties {

    @Value("${com.firstboot.web.name}")
    private String name;

    @Value("${com.firstboot.web.title}")
    private String title;

    @Value("${com.firstboot.web.desc}")
    private String desc;

    @Value("${com.firstboot.web.value}")
    private String value;

    @Value("${com.firstboot.web.number}")
    private Integer number;

    @Value("${com.firstboot.web.bignumber}")
    private Long bignumber;

    @Value("${com.firstboot.web.test1}")
    private Integer test1;

    @Value("${com.firstboot.web.test2}")
    private Integer test2;

//    @Value("${com.profile.test}")
//    private String pro;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }

    public Integer getTest1() {
        return test1;
    }

    public void setTest1(Integer test1) {
        this.test1 = test1;
    }

    public Integer getTest2() {
        return test2;
    }

    public void setTest2(Integer test2) {
        this.test2 = test2;
    }

//    public String getPro() {
//        return pro;
//    }
//
//    public void setPro(String pro) {
//        this.pro = pro;
//    }
}
