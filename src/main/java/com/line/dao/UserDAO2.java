package com.line.dao;

import java.sql.*;
import java.util.Map;

public class UserDAO2 {

    private Connection getConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Connection conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);
        return conn;
    }


    public void add(String id, String name, String password) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES (?,?,?)");
        ps.setString(1,id);
        ps.setString(2,name);
        ps.setString(3,password);

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public void findOne(int id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id: "+rs.getString(1));
            System.out.println("name: "+rs.getString(2));
            System.out.println("password: "+rs.getString(3));
        }

        ps.close();
        conn.close();
        rs.close();
    }

    public static void main(String[] args) throws SQLException {
        UserDAO sql = new UserDAO();
        sql.add("3","sky","123456768");
        sql.findOne(2);
    }
}
