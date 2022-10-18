package com.line.abstractdao;

import com.line.domain.User;

import java.sql.*;
import java.util.Map;

public abstract class AbstractUserDAO {

    //INSERT
    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES (?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2,user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    //SELECT
    public User get(String id) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();

        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        ps.close();
        conn.close();
        rs.close();

        return user;
    }

    //CONNECTION 추상화
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    //CONNECTION 구현
}


