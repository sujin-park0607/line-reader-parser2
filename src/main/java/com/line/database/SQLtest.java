package com.line.database;

import java.sql.*;
import java.util.Map;

public class SQLtest {
    public void add() throws SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);
        PreparedStatement ps = conn.prepareStatement("INSERT INTO seoul_hospital(id, name, password) VALUES (?,?,?)");
        ps.setString(1,"1");
        ps.setString(1,"Sujin");
        ps.setString(1,"1234");

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException {
        SQLtest test = new SQLtest();
        test.add();
    }

}