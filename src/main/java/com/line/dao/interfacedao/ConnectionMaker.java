package com.line.dao.interfacedao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    public Connection makeConnection() throws SQLException,ClassNotFoundException;
}
