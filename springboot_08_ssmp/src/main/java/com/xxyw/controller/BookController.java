package com.xxyw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxyw.domain.Book;
import com.xxyw.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    // 查所有
    @GetMapping
    public List<Book> getAllBook() {
        return bookService.list();
    }

    // 新增
    @PostMapping
    public Boolean saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    // 修改
    @PutMapping
    public Boolean updateBook(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    // 根据 ID 查询
    @GetMapping("{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    // 根据 ID 删除
    @DeleteMapping("{id}")
    public Boolean deleteBookById(@PathVariable Integer id) {
        return bookService.removeById(id);
    }

    // 分页查
    @GetMapping("{curPage}/{pageSize}")
    public IPage<Book> getByPage(@PathVariable Integer curPage, @PathVariable Integer pageSize) {
        return bookService.getPage(curPage, pageSize);
    }
}
