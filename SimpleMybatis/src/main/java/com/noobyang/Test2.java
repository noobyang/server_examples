package com.noobyang;

import com.noobyang.entity.Course;
import com.noobyang.entity.Student2;
import com.noobyang.entity.Student3;
import com.noobyang.entity.Student4;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        // 得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {

//            findById(sqlSession);

            findByGrade(sqlSession);

            findAllByCourseName(sqlSession);

            findAllByName(sqlSession);

        } catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    public static void findAllByName(SqlSession sqlSession) {
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        List<Course> courses = sqlSession.selectList("Course.findAllByName", "哈哈");
        for (Course course : courses) {
            System.out.println(course);
        }
        sqlSession.commit();

    }

    public static void findAllByCourseName(SqlSession sqlSession) {
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        List<Student4> students = sqlSession.selectList("Student4.findAllByCourseName", "android");
        for (Student4 student : students) {
            System.out.println(student);
        }
        sqlSession.commit();

    }

    public static void findByGrade(SqlSession sqlSession) {
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        List<Student3> students = sqlSession.selectList("Student3.findByGrade", "java");
        for (Student3 student : students) {
            System.out.println(student);
        }
        sqlSession.commit();

    }

    public static void findById(SqlSession sqlSession) {
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        Student2 student2 = sqlSession.selectOne("Student2.findById", 1);
        System.out.println(student2);
        sqlSession.commit();

    }

}
