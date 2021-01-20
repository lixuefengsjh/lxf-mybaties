package com.lxf;

import com.lxf.entity.User;

import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssmdemo?serverTimezone=UTC","root","root");
            String sql="SELECT * from  tb_user where id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"1");
            rs= ps.executeQuery();
            User user =new User();
           while (rs.next()){
               user.setId(rs.getString("id"));
               user.setUserName(rs.getString(2));
           }
            System.out.println(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){rs.close();}
//            if(ps!=null){ps.close();}
//            if(conn!=null){conn.close();}
        }
        String sql="SELECT * from  tb_user where id=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1,"2");
        rs= ps.executeQuery();
        User user =new User();
        while (rs.next()){
            user.setId(rs.getString("id"));
            user.setUserName(rs.getString(2));
        }
        System.out.println(user);
    }
}
