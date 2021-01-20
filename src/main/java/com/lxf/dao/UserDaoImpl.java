package com.lxf.dao;

import com.lxf.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl  implements  UserDao{
    private SqlSession sqlSession;
    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession=sqlSession;
    }

    @Override
    public User queryUserById(String id) {
        return  sqlSession.selectOne("com.lxf.dao.UserDao.queryUserById",id);
    }

    @Override
    public List<User> queryUserAll() {
        return   sqlSession.selectList("com.lxf.dao.UserDao.queryUserAll");
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    public void deleteUser(String id) {

    }
}
