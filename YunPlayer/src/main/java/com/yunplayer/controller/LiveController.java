package com.yunplayer.controller;

import com.yunplayer.model.LiveModel;
import com.yunplayer.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/live")
public class LiveController {
	private LiveService liveService;
	@Autowired
	public LiveController(LiveService liveService) {
		this.liveService = liveService;
	}

	@RequestMapping(value="getAllLives",method = RequestMethod.GET)
	@ResponseBody
	public List<LiveModel> getAllLives() {
		List<LiveModel> liveModels = liveService.getAllLives();
		return liveModels;
	}

	@RequestMapping(value="getLive",method = RequestMethod.GET)
	@ResponseBody
	public LiveModel getLive(String id) {
		LiveModel liveModel = liveService.getLive(id);
		return liveModel;
	}
}
