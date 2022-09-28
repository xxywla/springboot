package com.xxyw.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xxyw.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    // 测试根据 id 查询
    @Test
    void testGetById() {
        System.out.println("bookService.getBookById(1) = " + bookService.getBookById(1));
        System.out.println("bookService.getBookById(10) = " + bookService.getBookById(10));
    }

    // 测试查询所有
    @Test
    void testGetAll() {
        bookService.getAllBook().forEach(System.out::println);
    }

    // 测试分页功能
    @Test
    void testPage() {
        IPage<Book> page = bookService.getPage(2, 5);
        page.getRecords().forEach(System.out::println);
    }

    // 测试删除
    @Test
    void testDelete() {
        System.out.println("bookService.deleteById(12) = " + bookService.deleteById(12));
    }

    // 测试添加
    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("哲学");
        book.setName("《金刚经》");
        book.setDescription("过去心不可得");
        System.out.println("bookService.saveBook(book) = " + bookService.saveBook(book));
    }

    // 测试修改
    @Test
    void testUpdate() {
        Book book = new Book();

        book.setId(6);
        book.setName("《丰乳肥臀》");

        System.out.println("bookService.update(book) = " + bookService.update(book));
    }

}
