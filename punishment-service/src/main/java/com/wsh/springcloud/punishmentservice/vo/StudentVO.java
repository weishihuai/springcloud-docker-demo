package com.wsh.springcloud.punishmentservice.vo;

import java.io.Serializable;

/**
 * @Description: 学生VO对象
 * @author: weishihuai
 * @Date: 2019/3/4 14:38
 */
public class StudentVO implements Serializable {

    /**
     * 主键ID
     */
    private String pkid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public StudentVO() {
    }

    public StudentVO(String pkid, String name, int age) {
        this.pkid = pkid;
        this.name = name;
        this.age = age;
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

