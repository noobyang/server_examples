package com.yunplayer.service;

import com.yunplayer.dao.CourseDao;
import com.yunplayer.model.CourseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {
	@Autowired
	private CourseDao courseDao;

	public List<CourseModel> getAllCourses(){
		return courseDao.getAllCourses();
	}

	public CourseModel getCourse(String id) {
		return courseDao.getCourse(id);
	}

	boolean addCourse(CourseModel courseModel) {
		return courseDao.addCourse(courseModel);
	}

	boolean updateCourse(String id, String name) {
		return courseDao.updateCourse(id, name);
	}

	boolean deleteCourse(String id) {
		return courseDao.deleteCourse(id);
	}
}
