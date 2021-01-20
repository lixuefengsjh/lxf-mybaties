package com.lxf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @author: lxf
 * @create: 2021-01-07 15:13
 * @description:
 */
interface Dancer{
    public void dance();
}

class ZhangGuoRongDancer implements  Dancer{

    @Override
    public void dance() {
        System.out.println("开始跳舞");

    }
}
class ZhangGuoRongDancerProxy implements InvocationHandler {
    private Dancer danceer;

    public ZhangGuoRongDancerProxy(Dancer danceer) {
        this.danceer = danceer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("收了100");
        method.invoke(danceer,args);
        return null;
    }
}
public class ProxyDemo {
    public static void main(String[] args) {
        //将生成的动态代理类序列化出来
//        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Object obj = new Date();
        Class c;
        System.out.println(((Date) obj).getTime());
        Dancer zhangGuoRongDancer =new ZhangGuoRongDancer();
        InvocationHandler handler =new ZhangGuoRongDancerProxy(zhangGuoRongDancer);
        Dancer  proxy= (Dancer) Proxy.newProxyInstance(zhangGuoRongDancer.getClass().getClassLoader(),zhangGuoRongDancer.getClass().getInterfaces(),handler);
        proxy.dance();
    }
}
