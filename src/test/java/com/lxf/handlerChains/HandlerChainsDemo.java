package com.lxf.handlerChains;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lxf
 * @create: 2021-01-18 16:16
 * @description: 责任链设计模式
 */
public class HandlerChainsDemo {
    public static void main(String[] args) {

        DefineHandler DefineHandler2=new DefineHandler2(null);
        DefineHandler DefineHandler1=new DefineHandler1(DefineHandler2);
        DefineHandler1.doChain("three");

    }

}
