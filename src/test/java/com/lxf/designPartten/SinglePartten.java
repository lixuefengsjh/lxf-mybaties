package com.lxf.designPartten;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * 单列设计模式
 */
public class SinglePartten {
    private static volatile SinglePartten single;
    private SinglePartten() {
    }

    /**
     * 双端检索机制。加上volatile 防止指令重拍
     * @return
     */
    public static SinglePartten getSingle(){
            if(null==single){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (SinglePartten.class){
                    if(null==single){ single=new SinglePartten();}

                }

            }
        return single;
    }

    /**
     * 使用内部类的方式进行
     * 先加载对应的类，并生成class 类
     * 连接(校验，解析)
     * 初始化
     *开能出现的问题：反射攻击
     */
    private static class InnerClass{
        private static volatile SinglePartten single1=new SinglePartten();
    }
    public static SinglePartten getSingle1(){
        return InnerClass.single1;
    };

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 测试反射攻击
         */
        Constructor<SinglePartten> declaredConstructor = SinglePartten.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SinglePartten singlePartten = declaredConstructor.newInstance();
        System.out.println(singlePartten==SinglePartten.getSingle1());
    }
}
