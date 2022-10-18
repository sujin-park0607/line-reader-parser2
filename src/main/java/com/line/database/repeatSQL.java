package com.line.database;

import java.sql.*;
import java.util.Map;

public class repeatSQL {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public repeatSQL() throws SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        this.conn = DriverManager.getConnection(dbHost,dbUser,dbPassword);
    }

    public void fconnect() throws SQLException {
        ps.close();
        conn.close();
    }

    public void add(String id, String name, String password) throws SQLException {
        ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES (?,?,?)");
        ps.setString(1,id);
        ps.setString(2,name);
        ps.setString(3,password);

        ps.executeUpdate();
    }

    public void findOne(int id) throws SQLException {
        ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setInt(1,id);

        rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("id: "+rs.getString(1));
            System.out.println("name: "+rs.getString(2));
            System.out.println("password: "+rs.getString(3));
        }
    }

    public static void main(String[] args) throws SQLException {
        repeatSQL sql = new repeatSQL();
        sql.add("3","sky","123456768");
        sql.findOne(2);
        sql.fconnect();
    }
}
