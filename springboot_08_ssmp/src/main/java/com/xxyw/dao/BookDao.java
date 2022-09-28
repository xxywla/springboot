package com.xxyw.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxyw.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
