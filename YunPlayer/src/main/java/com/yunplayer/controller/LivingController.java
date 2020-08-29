package com.yunplayer.controller;

import com.yunplayer.model.LivingModel;
import com.yunplayer.service.LivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/living")
public class LivingController {
	private LivingService livingService;
	@Autowired
	public LivingController(LivingService livingService) {
		this.livingService = livingService;
	}

	@RequestMapping(value="getAllLivings",method = RequestMethod.GET)
	@ResponseBody
	public List<LivingModel> getAllLivings() {
		List<LivingModel> livingModels = livingService.getAllLivings();
		return livingModels;
	}

	@RequestMapping(value="getLiving",method = RequestMethod.GET)
	@ResponseBody
	public LivingModel getLiving(String id) {
		LivingModel livingModel = livingService.getLiving(id);
		return livingModel;
	}
}
