package com.lxf;

/**
 * @author: lxf
 * @create: 2021-01-05 16:44
 * @description: 回调函数---
 */
public class FallBackFunction {
    public static void main(String[] args) {
        add(1,plus(3));
    }

    private static int  add(int i, int plus) {
        return i+plus(3);
    }

    private static int plus(int param) {
        return param+1;
    }

 
}
