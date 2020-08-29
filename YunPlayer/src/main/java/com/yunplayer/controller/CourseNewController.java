package com.yunplayer.controller;

import com.yunplayer.model.CourseNewModel;
import com.yunplayer.service.CourseNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/newCourse")
public class CourseNewController {
	private CourseNewService courseNewService;
	@Autowired
	public CourseNewController(CourseNewService courseNewService) {
		this.courseNewService = courseNewService;
	}

	@RequestMapping(value="getAllNewCourses",method = RequestMethod.GET)
	@ResponseBody
	public List<CourseNewModel> getAllNewCourses() {
		List<CourseNewModel> courseNewModels = courseNewService.getAllNewCourses();
		return courseNewModels;
	}

	@RequestMapping(value="getNewCourse",method = RequestMethod.GET)
	@ResponseBody
	public CourseNewModel getNewCourse(String id) {
		CourseNewModel courseNewModel = courseNewService.getNewCourse(id);
		return courseNewModel;
	}
}
