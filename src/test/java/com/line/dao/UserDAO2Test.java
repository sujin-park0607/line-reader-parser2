package com.line.dao;

import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDAO2Test {

    @Test
    void addAndSelect(){
        ClassUserDAO userDao = new ClassUserDAO();
        User user = new User("13","SSJJIINN","06070607");
        try {
            userDao.add(user);

            User selectedUser = userDao.get("13");
            System.out.println(selectedUser.getName());
            Assertions.assertEquals("SSJJIINN", selectedUser.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}