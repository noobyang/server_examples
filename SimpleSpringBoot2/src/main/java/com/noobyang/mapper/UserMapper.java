package com.noobyang.mapper;

import com.noobyang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUser(int id);

    @Select("SELECT * FROM user")
    User selectUser();

    @Select("insert into user(name,age) values(#{name},#{age})")
    void insertUser(String name, int age);

}
