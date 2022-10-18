package com.line.dao;

import com.line.domain.User;
import com.line.interfacedao.DaoFactory;
import com.line.interfacedao.InterfaceUserDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDAO2Test {

//    @Test
//    void addAndSelect(){
//        InterfaceUserDao userDao = new InterfaceUserDao();
//        User user = new User("14","SSJJIINN","06070607");
//        try {
//            userDao.add(user);
//
//            User selectedUser = userDao.get("14");
//            System.out.println(selectedUser.getName());
//            Assertions.assertEquals("SSJJIINN", selectedUser.getName());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Test
    void factoryConnection(){
        InterfaceUserDao userDao = new DaoFactory().interfaceUserDao();
        User user = new User("16","SSJJIINN","06070607");
        try {
            userDao.add(user);

            User selectedUser = userDao.get("16");
            System.out.println(selectedUser.getName());
            Assertions.assertEquals("SSJJIINN", selectedUser.getName());

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}