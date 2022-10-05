package com.xxyw.controller;

import com.xxyw.controller.utils.R;
import com.xxyw.domain.Book;
import com.xxyw.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    // 查所有
    @GetMapping
    public R getAllBook() {
        return new R(true, bookService.list());
    }

    // 新增
    @PostMapping
    public R saveBook(@RequestBody Book book) {
        return new R(bookService.save(book));
    }

    // 修改
    @PutMapping
    public R updateBook(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    // 根据 ID 查询
    @GetMapping("{id}")
    public R getBookById(@PathVariable Integer id) {

        return new R(true, bookService.getById(id));
    }

    // 根据 ID 删除
    @DeleteMapping("{id}")
    public R deleteBookById(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    // 分页查
    @GetMapping("{curPage}/{pageSize}")
    public R getByPage(@PathVariable Integer curPage, @PathVariable Integer pageSize) {
        return new R(true, bookService.getPage(curPage, pageSize));
    }
}
