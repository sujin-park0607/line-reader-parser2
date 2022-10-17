package com.line.dao;

import com.line.database.SQLtest;

import java.sql.*;
import java.util.Map;

public class HospitalDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public HospitalDAO() throws SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");
        this.conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
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

    public void findAll() throws SQLException {
        ps = conn.prepareStatement("select * from seoul_hospital");
        rs = ps.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString(1) + "\t"+
                    rs.getString(2) + "\t"+
                    rs.getString(3) + "\t"+
                    rs.getString(4) + "\t"+
                    rs.getString(5) + "\t"+
                    rs.getString(6) + "\t"+
                    rs.getString(7) + "\t"
            );
        }
    }

}
