package com.xxyw.dao;

import com.xxyw.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {

    @Select("select * from t_book where book_id = #{bookId}")
    Book getBookById(Integer bookId);
}
