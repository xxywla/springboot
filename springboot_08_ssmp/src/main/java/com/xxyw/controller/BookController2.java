package com.xxyw.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxyw.controller.utils.R;
import com.xxyw.domain.Book;
import com.xxyw.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    public R saveBook(@RequestBody Book book) throws Exception {

        if (book.getName().equals("123")) {
            throw new IOException("人为异常");
        }
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "成功啦^-^" : "失败了-_-|");
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
    //@GetMapping("{curPage}/{pageSize}")
    public R getByPage(@PathVariable Integer curPage, @PathVariable Integer pageSize) {
        IPage<Book> page = bookService.getPage(curPage, pageSize);

        // 如果当前的页数超过了实际页数 重新查一下最后一页
        if (curPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize);
        }

        return new R(true, page);
    }

    // 分页+条件查
    @GetMapping("{curPage}/{pageSize}")
    public R getByPage(@PathVariable Integer curPage, @PathVariable Integer pageSize, Book book) {
        IPage<Book> page = bookService.getPage(curPage, pageSize, book);

        // 如果当前的页数超过了实际页数 重新查一下最后一页
        if (curPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }

        return new R(true, page);
    }
}
