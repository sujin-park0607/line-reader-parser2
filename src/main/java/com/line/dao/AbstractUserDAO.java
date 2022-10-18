package com.line.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractUserDAO {
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

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}


