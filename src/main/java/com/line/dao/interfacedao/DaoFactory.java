package com.line.dao.interfacedao;

public class DaoFactory {
    public InterfaceUserDao interfaceUserDao(){
        ConnectionMaker connectionMaker = new AWSConnectionMaker();
        InterfaceUserDao userDao = new InterfaceUserDao(connectionMaker);
        return userDao;
    }
}
