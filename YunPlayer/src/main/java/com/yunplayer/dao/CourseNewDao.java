package com.yunplayer.dao;

import com.yunplayer.model.CourseNewModel;

import java.util.List;

public interface CourseNewDao {
    List<CourseNewModel> getAllNewCourses();

    CourseNewModel getNewCourse(String id);

    boolean addNewCourse(CourseNewModel courseNewModel);

    boolean updateNewCourse(String id, String cid);

    boolean deleteNewCourse(String id);
}
