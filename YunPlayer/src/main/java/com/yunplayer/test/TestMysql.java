package com.yunplayer.test;

import java.sql.*;

/**
 * TestMysql
 * </p>
 * Created by LiYang on 2019/6/14.
 */
public class TestMysql {

    public static void main(String[] srgs) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/yun_player?useUnicode=true&characterEncoding=utf-8";
            Connection connection = DriverManager.getConnection(url, "root", "ly0904010214@");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM user");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
