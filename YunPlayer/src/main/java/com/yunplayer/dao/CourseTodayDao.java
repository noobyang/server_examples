package com.yunplayer.dao;

import com.yunplayer.model.CourseTodayModel;

import java.util.List;

public interface CourseTodayDao {
    List<CourseTodayModel> getAllTodayCourses();

    CourseTodayModel getTodayCourse(String id);

    boolean addTodayCourse(CourseTodayModel courseTodayModel);

    boolean updateTodayCourse(String id, String cid);

    boolean deleteTodayCourse(String id);
}
