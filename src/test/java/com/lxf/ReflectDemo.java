package com.lxf;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: lxf
 * @create: 2021-01-08 17:21
 * @description: 反射
 */
public class ReflectDemo {
    public static void main(String[] args) {
        System.out.println("================获取对应的class 对象======");
        //获取对应的class 对象
        Class<?> clazz=null;
        try {
            clazz=Class.forName("com.lxf.entity.Person");
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("================获取所有类中对应的属性======");
        //获取所有类中对应的属性
        Field[] fields = clazz.getDeclaredFields();
       for(Field field:fields){
           System.out.println(field);
       }
        System.out.println("================获取所有申明的方法======");
       //获取所有申明的方法、
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println(method);
        }
        try {
            Method m=clazz.getDeclaredMethod("setName",String.class);
            System.out.println("================获取特定申明的方法======");
            System.out.println(m);
            System.out.println(m.getModifiers());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //获取所有构造方法

        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println("================获取构造方法======\n");
        for (Constructor c:
        constructors) {
            System.out.println(c);
        }
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println("================获取所有的注释======\n");
        for (Annotation a:
        annotations) {
            System.out.println(a);
        }

        int i = clazz.getModifiers();
        System.out.println(i);
    }
}
