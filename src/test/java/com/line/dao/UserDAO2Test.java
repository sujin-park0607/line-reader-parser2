package com.line.dao;

import com.line.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDAO2Test {

    @Test
    void addAndSelect(){
        UserDAO2 userDao = new UserDAO2();
        User user = new User("11","SSJJIINN","06070607");
        try {
            userDao.add(user);

            User selectedUser = userDao.findOne("11");
            System.out.println(selectedUser.getName());
            Assertions.assertEquals("SSJJIINN", selectedUser.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}