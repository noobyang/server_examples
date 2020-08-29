package com.yunplayer.service;

import com.yunplayer.dao.CourseTodayDao;
import com.yunplayer.model.CourseTodayModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseTodayService {
    @Autowired
    private CourseTodayDao courseTodayDao;

    public List<CourseTodayModel> getAllTodayCourses(){
        return courseTodayDao.getAllTodayCourses();
    }

    public CourseTodayModel getTodayCourse(String id) {
        return courseTodayDao.getTodayCourse(id);
    }

    boolean addTodayCourse(CourseTodayModel courseTodayModel) {
        return courseTodayDao.addTodayCourse(courseTodayModel);
    }

    boolean updateTodayCourse(String id, String cid) {
        return courseTodayDao.updateTodayCourse(id, cid);
    }

    boolean deleteTodayCourse(String id) {
        return courseTodayDao.deleteTodayCourse(id);
    }
}
