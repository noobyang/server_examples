package com.yunplayer.controller;

import com.yunplayer.model.CourseModel;
import com.yunplayer.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
	private CourseService courseService;
	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping(value="getAllCourses",method = RequestMethod.GET)
	@ResponseBody
	public List<CourseModel> getAllCourses() {
		List<CourseModel> courseModels = courseService.getAllCourses();
		return courseModels;
	}

	@RequestMapping(value="getCourse",method = RequestMethod.GET)
	@ResponseBody
	public CourseModel getCourse(String id) {
		CourseModel courseModel = courseService.getCourse(id);
		return courseModel;
	}
}
