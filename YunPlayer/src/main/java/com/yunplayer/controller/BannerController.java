package com.yunplayer.controller;

import com.yunplayer.model.BannerModel;
import com.yunplayer.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/banner")
public class BannerController {
	private BannerService bannerService;
	@Autowired
	public BannerController(BannerService bannerService) {
		this.bannerService = bannerService;
	}

	@RequestMapping(value="getAllBanners",method = RequestMethod.GET)
	@ResponseBody
	public List<BannerModel> getAllBanners() {
		List<BannerModel> bannerModels = bannerService.getAllBanners();
		return bannerModels;
	}

	@RequestMapping(value="getUser",method = RequestMethod.GET)
	@ResponseBody
	public BannerModel getBanner(String id) {
		BannerModel bannerModel = bannerService.getBanner(id);
		return bannerModel;
	}
}
