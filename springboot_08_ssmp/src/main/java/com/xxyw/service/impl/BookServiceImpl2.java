package com.xxyw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxyw.dao.BookDao;
import com.xxyw.domain.Book;
import com.xxyw.service.IBookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl2 extends ServiceImpl<BookDao, Book> implements IBookService {
}
