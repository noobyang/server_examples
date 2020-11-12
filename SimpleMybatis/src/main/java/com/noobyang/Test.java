package com.noobyang;

import com.noobyang.entity.Student;
import org.apache.ibatis.session.SqlSession;

public class Test {

    public static void main(String[] args) {

        addStudent();


    }

    public static void addStudent() {
        Student student = new Student(1, "noobyang", 10000d);
        // 得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.insert("add", student);
            sqlSession.commit();

            Student user = sqlSession.selectOne("findById", 1);
            System.out.println(user.getName());
        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }

    }


}
