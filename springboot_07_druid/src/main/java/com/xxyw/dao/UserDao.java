package com.xxyw.dao;

import com.xxyw.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from t_user where id = #{userId}")
    User getUserById(Integer userId);
}
