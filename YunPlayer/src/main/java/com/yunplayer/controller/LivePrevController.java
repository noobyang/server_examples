package com.yunplayer.controller;

import com.yunplayer.model.LivePrevModel;
import com.yunplayer.service.LivePrevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/livePrev")
public class LivePrevController {
	private LivePrevService livePrevService;
	@Autowired
	public LivePrevController(LivePrevService livePrevService) {
		this.livePrevService = livePrevService;
	}

	@RequestMapping(value="getAllLivePrevs",method = RequestMethod.GET)
	@ResponseBody
	public List<LivePrevModel> getAllLivePrevs() {
		List<LivePrevModel> livePrevModels = livePrevService.getAllLivePrevs();
		return livePrevModels;
	}

	@RequestMapping(value="getLivePrev",method = RequestMethod.GET)
	@ResponseBody
	public LivePrevModel getLivePrev(String id) {
		LivePrevModel livePrevModel = livePrevService.getLivePrev(id);
		return livePrevModel;
	}
}
