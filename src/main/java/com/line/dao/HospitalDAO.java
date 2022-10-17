package com.line.dao;

import com.line.database.SQLtest;

import java.sql.*;
import java.util.Map;

public class HospitalDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public void connect() throws SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
    }

    public void fconnect() throws SQLException {
        ps.close();
        conn.close();
    }
    public void add(String id, String address, String district, String category, int emergency_room, String name, String subdivision) throws SQLException {

        ps = conn.prepareStatement("INSERT INTO seoul_hospital(id, address, district, category, emergency_room, name, subdivision) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1,id);
        ps.setString(2,address);
        ps.setString(3,district);
        ps.setString(4,category);
        ps.setInt(5,emergency_room);
        ps.setString(6,name);
        ps.setString(7,subdivision);

        ps.executeUpdate();
    }

//    public void find(int id) throws SQLException {
//        ps = conn.prepareStatement("select * from seoul_hospital where id=?");
//        ps.setInt(1,id);
//
//        rs = ps.executeQuery();
//
//        while (rs.next()){
//            System.out.println("id: "+rs.getString(1));
//            System.out.println("name: "+rs.getString(2));
//            System.out.println("password: "+rs.getString(3));
//        }
//    }

}
