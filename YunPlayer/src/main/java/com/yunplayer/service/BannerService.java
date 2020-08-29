package com.yunplayer.service;

import com.yunplayer.dao.BannerDao;
import com.yunplayer.model.BannerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerService {
	@Autowired
	private BannerDao bannerDao;

	public List<BannerModel> getAllBanners(){
		return bannerDao.getAllBanners();
	}

	public BannerModel getBanner(String id) {
		return bannerDao.getBanner(id);
	}

	boolean addBanner(BannerModel userModel) {
		return bannerDao.addBanner(userModel);
	}

	boolean updateBanner(String id, String piclink) {
		return bannerDao.updateBanner(id, piclink);
	}

	boolean deleteBanner(String id) {
		return bannerDao.deleteBanner(id);
	}
}
