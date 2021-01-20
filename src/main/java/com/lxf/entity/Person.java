package com.lxf.entity;

import lombok.Data;
import lombok.extern.java.Log;

/**
 * @author: lxf
 * @create: 2021-01-05 14:26
 * @description:
 */

public class Person {
    private String name;
    private Integer age;
    public  String add;

    public Person(String name, Integer age, String add) {
        this.name = name;
        this.age = age;
        this.add = add;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
