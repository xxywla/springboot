package com.xxyw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxyw.domain.Book;

public interface IBookService extends IService<Book> {
    IPage<Book> getPage(Integer curPage, Integer pageSize);
}
