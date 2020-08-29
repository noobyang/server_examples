package com.yunplayer.controller;

import com.yunplayer.model.CourseModel;
import com.yunplayer.model.CourseTodayModel;
import com.yunplayer.service.CourseService;
import com.yunplayer.service.CourseTodayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/todayCourse")
public class CourseTodayController {
	private CourseTodayService courseTodayService;
	@Autowired
	public CourseTodayController(CourseTodayService courseTodayService) {
		this.courseTodayService = courseTodayService;
	}

	@RequestMapping(value="getAllTodayCourses",method = RequestMethod.GET)
	@ResponseBody
	public List<CourseTodayModel> getAllTodayCourses() {
		List<CourseTodayModel> courseTodayModels = courseTodayService.getAllTodayCourses();
		return courseTodayModels;
	}

	@RequestMapping(value="getTodayCourse",method = RequestMethod.GET)
	@ResponseBody
	public CourseTodayModel getTodayCourse(String id) {
		CourseTodayModel courseTodayModel = courseTodayService.getTodayCourse(id);
		return courseTodayModel;
	}
}
