package com.lxf.handlerChains;

/**
 * @author: lxf
 * @create: 2021-01-18 16:19
 * @description:
 */
public class DefineHandler1 extends DefineHandler {

    public DefineHandler1(DefineHandler next) {
        super(next);
    }

    @Override
    public void doChain(String req) {
        if("one".equals(req)){
            System.out.println(DefineHandler1.class.getName()+"执行one===========");
        }else {
            getNext().doChain(req);
        }

    }
}
