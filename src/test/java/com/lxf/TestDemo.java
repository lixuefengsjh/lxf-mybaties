package com.lxf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lxf
 * @create: 2021-01-05 08:57
 * @description: 日常测试
 */
public class TestDemo {
    public static void main(String[] args) {
        List<String> s=new ArrayList();
        s.add("lxf");
        s.add("sjh");
        s.add(0,"cc");
        System.out.println(s.toString());
    }
}
