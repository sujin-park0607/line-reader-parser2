package com.line.dao;
import com.line.domain.Hospital;

import java.sql.*;
import java.util.List;
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
    public void add(List<Hospital> hospital) throws SQLException {

        for (Hospital h : hospital) {
            ps = conn.prepareStatement("INSERT INTO seoul_hospital(id, address, district, category, emergency_room, name, subdivision) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1,h.getId());
            ps.setString(2,h.getAddress());
            ps.setString(3,h.getDistrict());
            ps.setString(4,h.getCategory());
            ps.setInt(5,h.getEmergencyRoom());
            ps.setString(6,h.getName());
            ps.setString(7,h.getSubdivision());
        }

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
