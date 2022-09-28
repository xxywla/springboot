package com.xxyw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxyw.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTest {

    @Autowired
    private IBookService bookService;

    // 测试根据 id 查询
    @Test
    void testGetById() {
        System.out.println("bookService.getBookById(1) = " + bookService.getById(1));
        System.out.println("bookService.getBookById(10) = " + bookService.getById(10));
    }

    // 测试查询所有
    @Test
    void testGetAll() {
        bookService.list().forEach(System.out::println);
    }

    // 测试分页功能
    @Test
    void testPage() {

        IPage<Book> page = new Page<>(2, 5);
        bookService.page(page);
        page.getRecords().forEach(System.out::println);
    }

    // 测试删除
    @Test
    void testDelete() {
        System.out.println("bookService.deleteById(12) = " + bookService.removeById(19));
    }

    // 测试添加
    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("哲学");
        book.setName("《般若波罗蜜心经》");
        book.setDescription("大慈大悲");
        System.out.println("bookService.saveBook(book) = " + bookService.save(book));
    }

    // 测试修改
    @Test
    void testUpdate() {
        Book book = new Book();

        book.setId(7);
        book.setType("人生奥义");
        book.setName("《生死疲劳》");

        System.out.println("bookService.update(book) = " + bookService.updateById(book));
    }

}
