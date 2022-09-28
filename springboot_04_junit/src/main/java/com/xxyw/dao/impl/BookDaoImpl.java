package com.xxyw.dao.impl;

import com.xxyw.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void saveBook() {
        System.out.println("保存成功");
    }
}
