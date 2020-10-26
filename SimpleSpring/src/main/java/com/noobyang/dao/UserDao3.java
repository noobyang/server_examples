package com.noobyang.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao3 {

    private static final Logger log = LoggerFactory.getLogger(UserDao3.class);

    private JdbcTemplate jdbcTemplate;

    public UserDao3(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save() {
        log.info("save before ");
        String sql = "INSERT INTO user (id, name, sex, age) VALUES (13, '大屯', '女', 56);";
        jdbcTemplate.update(sql);
        log.info("save after ");
    }

}
