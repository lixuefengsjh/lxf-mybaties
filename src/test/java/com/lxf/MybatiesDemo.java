package com.lxf;

import com.lxf.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatiesDemo {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream ins = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ins);
        SqlSession session = factory.openSession();
        try {
            User user = session.selectOne("MyMapper.selectUser", "1");
            System.out.println(user);
        } finally {
            session.close();
        }
    }
}
