package com.yunplayer.dao;

import com.yunplayer.model.BannerModel;

import java.util.List;

public interface BannerDao {
	List<BannerModel> getAllBanners();

	BannerModel getBanner(String id);

	boolean addBanner(BannerModel userModel);

	boolean updateBanner(String id, String piclink);

	boolean deleteBanner(String id);
}
