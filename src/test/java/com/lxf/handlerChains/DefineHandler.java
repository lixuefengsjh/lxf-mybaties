package com.lxf.handlerChains;

/**
 * @author: lxf
 * @create: 2021-01-18 16:17
 * @description:
 */
public abstract  class DefineHandler {
    private  DefineHandler next;

    public DefineHandler(DefineHandler next) {
        this.next = next;
    }

    public DefineHandler getNext() {
        return next;
    }
    public  abstract void  doChain(String req);
}
