package com.yunplayer.service;

import com.yunplayer.dao.CourseNewDao;
import com.yunplayer.model.CourseNewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseNewService {
    @Autowired
    private CourseNewDao courseNewDao;

    public List<CourseNewModel> getAllNewCourses(){
        return courseNewDao.getAllNewCourses();
    }

    public CourseNewModel getNewCourse(String id) {
        return courseNewDao.getNewCourse(id);
    }

    boolean addNewCourse(CourseNewModel courseNewModel) {
        return courseNewDao.addNewCourse(courseNewModel);
    }

    boolean updateNewCourse(String id, String cid) {
        return courseNewDao.updateNewCourse(id, cid);
    }

    boolean deleteNewCourse(String id) {
        return courseNewDao.deleteNewCourse(id);
    }
}
