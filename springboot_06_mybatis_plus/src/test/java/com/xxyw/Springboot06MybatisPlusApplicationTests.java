package com.xxyw;

import com.xxyw.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot06MybatisPlusApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println("userDao.selectById(1) = " + userDao.selectById(1));
        System.out.println("userDao.selectById(2) = " + userDao.selectById(2));
        userDao.selectList(null).forEach(System.out::println);
    }

}
