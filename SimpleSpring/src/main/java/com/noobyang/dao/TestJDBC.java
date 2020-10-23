package com.noobyang.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class TestJDBC {

    private static final Logger log = LoggerFactory.getLogger(TestJDBC.class);

    public static void main(String[] args) {
        connectDB();
    }

    private static void connectDB() {
        try {
            // Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
            // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 连接对象
            // jdbc:mysql://localhost:3306/db_testjpa?serverTimezone=GMT%2B8&useSSL=false
            Connection con = DriverManager.getConnection("jdbc:mysql:///mydatabase?serverTimezone=GMT%2B8&useSSL=false", "liyang", "liyang");
            // 执行命令对象
            Statement stmt =  con.createStatement();

//            execInsert(stmt);

            execQuery(stmt);


            // 关闭
            stmt.close();
            con.close();
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    private static void execQuery(Statement stmt) throws SQLException {
        String sql = "SELECT * FROM user";
        ResultSet rs =  stmt.executeQuery(sql);
        while(rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String sex = rs.getString(3);
            int age = rs.getInt(4);

            log.info("id " + id);
            log.info("name " + name);
            log.info("sex " + sex);
            log.info("age " + age);
        }
    }

    private static void execInsert(Statement stmt) throws SQLException {
        String sql = "INSERT INTO user (id, name, sex, age) VALUES (8, '大屯', '女', 36);";
        stmt.execute(sql);

    }

}
