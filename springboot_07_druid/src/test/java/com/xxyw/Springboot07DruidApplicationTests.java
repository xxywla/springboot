package com.xxyw;

import com.xxyw.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot07DruidApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println("userDao.getUserById(1) = " + userDao.getUserById(1));
        System.out.println("userDao.getUserById(2) = " + userDao.getUserById(12));
    }

}
