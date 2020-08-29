package com.yunplayer.dao;

import com.yunplayer.model.CourseModel;

import java.util.List;

public interface CourseDao {
    List<CourseModel> getAllCourses();

    CourseModel getCourse(String id);

    boolean addCourse(CourseModel userModel);

    boolean updateCourse(String id, String name);

    boolean deleteCourse(String id);
}
