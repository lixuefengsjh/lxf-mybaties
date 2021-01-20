package com.lxf.handlerChains;

/**
 * @author: lxf
 * @create: 2021-01-18 16:22
 * @description:
 */
public class DefineHandler2 extends DefineHandler {

    public DefineHandler2(DefineHandler next) {
        super(next);
    }

    @Override
    public void doChain(String req) {
        if("two".equals(req)){
            System.out.println(DefineHandler2.class.getName()+"执行two===========");
        }else {
            System.out.println("无人执行");
        }

    }
}