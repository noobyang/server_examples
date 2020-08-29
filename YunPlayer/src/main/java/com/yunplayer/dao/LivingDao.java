package com.yunplayer.dao;

import com.yunplayer.model.LivingModel;

import java.util.List;

public interface LivingDao {
	List<LivingModel> getAllLivings();
	LivingModel getLiving(String id);
	boolean addLiving(LivingModel livingModel);
	boolean updateLiving(String id, String liveid);
	boolean deleteLiving(String id);
}
