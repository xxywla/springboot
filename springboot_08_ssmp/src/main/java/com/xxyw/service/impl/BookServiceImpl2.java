package com.xxyw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxyw.dao.BookDao;
import com.xxyw.domain.Book;
import com.xxyw.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl2 extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public IPage<Book> getPage(Integer curPage, Integer pageSize) {
        IPage<Book> page = new Page<>(curPage, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(Integer curPage, Integer pageSize, Book bookCondition) {
        IPage<Book> page = new Page<>(curPage, pageSize);

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(bookCondition.getType()), Book::getType, bookCondition.getType());
        lqw.like(Strings.isNotEmpty(bookCondition.getName()), Book::getName, bookCondition.getName());
        lqw.like(Strings.isNotEmpty(bookCondition.getDescription()), Book::getDescription, bookCondition.getDescription());

        bookDao.selectPage(page, lqw);
        return page;
    }
}
