package com.noobyang;

import com.noobyang.entity.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        // 得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {

            update(sqlSession);

//            delete(sqlSession);

//            findAll(sqlSession);

//            findById(sqlSession);

//            add(sqlSession);

        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    public static void update(SqlSession sqlSession) {
        Student student = new Student(3, "noobyang1", 1030d);
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        int id = sqlSession.update("StudentID.update", student);
        System.out.println(id);
        sqlSession.commit();

    }

    public static void delete(SqlSession sqlSession) {
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        int id = sqlSession.delete("StudentID.delete", 3);
        System.out.println(id);
        sqlSession.commit();

    }

    public static void findAll(SqlSession sqlSession) {
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        List<Student> students = sqlSession.selectList("StudentID.findAll");
        for (Student student : students) {
            System.out.println(student.getName());
        }
        sqlSession.commit();

    }

    public static void findById(SqlSession sqlSession) {
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        Student student = sqlSession.selectOne("StudentID.findById", 3);
        System.out.println(student.getName());
        sqlSession.commit();

    }

    public static void add(SqlSession sqlSession) {
        Student student = new Student(3, "noobyang", 10000d);

        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        int id = sqlSession.insert("StudentID.add", student);
        System.out.println(id);
        sqlSession.commit();

    }
}
