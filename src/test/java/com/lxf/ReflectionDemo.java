package com.lxf;

import com.lxf.entity.User;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

interface  UserDemo{
    @Select("SELECT * FROM tb_user WHERE id = #{id} and sex=#{sex};")
    public User queryUserById(String id,Integer sex );
}
public class ReflectionDemo {

    public static void main(String[] args) {
        UserDemo userDemo= (UserDemo) Proxy.newProxyInstance(ReflectionDemo.class.getClassLoader(),new   Class<?>[]{UserDemo.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Select annotation = method.getAnnotation(Select.class);
                if(null!=annotation){
                    String[] va = annotation.value();
                    Map<String ,Object> map= setPararm (method, args);
                    System.out.println(map);

                };
                User user =new User();
                return user;
            }
        });
        User user=  userDemo.queryUserById("2",1);
        System.out.println(user);
    }
    private  static String paraseSql(String sql,Map<String ,Object> map){
        int i=sql.length();
        StringBuilder sb=new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(sql.charAt(j));
            if("#".equals(sql.charAt(j))){
                if(!"{".equals(sql.charAt(j+1))){
                    throw  new RuntimeException(String.format("原始sql为:%s,解析异常%d处应该为{,已经解析出来的语句为%s",sql,j+1));
                };
                sb=paddingSql( sb, map,sql,j);
                    continue;
            }
        }
        return  String.valueOf(sb);
    }

    private static StringBuilder paddingSql(StringBuilder sb, Map<String, Object> map, String sql, int j) {
        StringBuilder mark=new StringBuilder();
        for (int i = j+2; i <sql.length() ; i++) {
//            if(){}
        }
    return sb;
    }

    ;
    private  static Map<String ,Object> setPararm(Method method, Object[] args){
        Map<String ,Object> map =new HashMap<String, Object>();
        Parameter[] parameters = method.getParameters();
         AtomicInteger index = new AtomicInteger(0);
        Arrays.asList(parameters).stream().forEach(e->{
            map.put(e.getName(),args[index.get()]);
            index.incrementAndGet();

        });
        return  map;
    };
}
