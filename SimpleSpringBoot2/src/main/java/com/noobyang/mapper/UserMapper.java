package com.noobyang.mapper;

import com.noobyang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUser(int id);

    /**
     * Warring: java.lang.IllegalArgumentException: Mapped Statements collection already contains value for
     *
     * 注意方法重名，不支持参数重载
     */
//    @Select("SELECT * FROM user")
//    List<User> selectUsers();

    @Select("insert into user(name,age) values(#{name},#{age})")
    void insertUser(String name, int age);

}
