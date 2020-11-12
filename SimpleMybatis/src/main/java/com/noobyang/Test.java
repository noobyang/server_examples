package com.noobyang;

import com.noobyang.entity.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        // 得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {

            insertByCondition(sqlSession);

//            deleteByCondition(sqlSession);

//            updateByCondition(sqlSession);

//            findByCondition(sqlSession);

//            pagination(sqlSession);

//            update(sqlSession);

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

    public static void insertByCondition(SqlSession sqlSession) {
        Student student = new Student(7, "noobyang", null);
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        int size = sqlSession.insert("StudentID.insertByCondition", student);
        System.out.println(size);
        sqlSession.commit();

    }

    public static void deleteByCondition(SqlSession sqlSession) {
        int[] ids = new int[]{1, 2, 3};
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        int size = sqlSession.delete("StudentID.deleteByCondition", ids);
        System.out.println(size);
        sqlSession.commit();

    }

    public static void updateByCondition(SqlSession sqlSession) {
        Map<String, Object> map = new HashMap();
        map.put("id", 3);
        map.put("name", null);
        map.put("sal", 1000d);
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        int size = sqlSession.update("StudentID.updateByCondition", map);
        System.out.println(size);
        sqlSession.commit();

    }

    public static void findByCondition(SqlSession sqlSession) {
        Map<String, Object> map = new HashMap();
        map.put("name", "noobyang1");
        map.put("sal", null);
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        List<Student> students = sqlSession.selectList("StudentID.findByCondition", map);
        for (Student student : students) {
            System.out.println(student.getName());
        }
        sqlSession.commit();

    }

    public static void pagination(SqlSession sqlSession) {
        Map<String, Object> map = new HashMap();
        map.put("start", 0);
        map.put("end", 10);
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        List<Student> students = sqlSession.selectList("StudentID.pagination", map);
        for (Student student : students) {
            System.out.println(student.getName());
        }
        sqlSession.commit();

    }

    public static void update(SqlSession sqlSession) {
        Student student = new Student(3, "noobyang1", 1030d);
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        int size = sqlSession.update("StudentID.update", student);
        System.out.println(size);
        sqlSession.commit();

    }

    public static void delete(SqlSession sqlSession) {
        // 映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
        int size = sqlSession.delete("StudentID.delete", 3);
        System.out.println(size);
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
        int size = sqlSession.insert("StudentID.add", student);
        System.out.println(size);
        sqlSession.commit();

    }
}
