package com.xxyw.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxyw.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSelect() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testInsert() {
        Book book = new Book();
        book.setType("新的数据");
        book.setName("《宫本武藏》");
        book.setDescription("天下无双");

        bookDao.insert(book);
    }

    @Test
    void testGetAll() {
        bookDao.selectList(null).forEach(System.out::println);
    }

    @Test
    void testUpdate() {
        Book book = new Book();

        book.setId(19);

        book.setType("新的数据修改了");
        book.setName("《宫本武藏》");
        book.setDescription("天下无双");

        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(20);
    }

    @Test
    void testPage() {

        IPage<Book> page = new Page<>(2, 5);

        bookDao.selectPage(page, null);

        System.out.println("page.getPages() = " + page.getPages());

        System.out.println("page.getCurrent() = " + page.getCurrent());

        System.out.println("page.getSize() = " + page.getSize());

        System.out.println("page.getTotal() = " + page.getTotal());

        page.getRecords().forEach(System.out::println);

    }

    // 测试 Mybatis-Plus的条件查询

    @Test
    void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Java");
        bookDao.selectList(qw).forEach(System.out::println);
    }

    @Test
    void testGetBy2() {

        //String name = null;
        String name = "Java";

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null, Book::getName, name);
        bookDao.selectList(lqw);
    }
}
