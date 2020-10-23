package com.noobyang.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao implements IUserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save() {
        String sql = "INSERT INTO user (id, name, sex, age) VALUES (9, '大大屯', '女', 56);";
        jdbcTemplate.update(sql);
    }

}
