package com.xxyw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxyw.domain.Book;

import java.util.List;

public interface BookService {
    // 添加
    boolean saveBook(Book book);

    // 删除
    boolean deleteById(Integer id);

    // 修改
    boolean update(Book book);

    // 根据 id 查询
    Book getBookById(Integer id);

    // 查询所有
    List<Book> getAllBook();

    // 分页查询
    IPage<Book> getPage(int currentPage, int pageSize);
}
