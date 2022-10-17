package com.line.database;

import java.sql.*;
import java.util.Map;

public class SQLtest {
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
    public void add() throws SQLException {

        ps = conn.prepareStatement("INSERT INTO users(id, name, password) VALUES (?,?,?)");
        ps.setString(1,"1");
        ps.setString(2,"Sujin");
        ps.setString(3,"1234");
        ps.executeUpdate();

    }

    public void select(int id) throws SQLException {
        ps = conn.prepareStatement("select * from users where id=?");
        ps.setInt(1,id);

        rs = ps.executeQuery();

        while (rs.next()){
            System.out.println("id: "+rs.getString(1));
            System.out.println("name: "+rs.getString(2));
            System.out.println("password: "+rs.getString(3));
        }
    }

    public static void main(String[] args) throws SQLException {
        SQLtest test = new SQLtest();
//        test.add();
        test.connect();
        test.select(1);
    }

}