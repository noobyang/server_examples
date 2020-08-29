package com.yunplayer.service;

import com.yunplayer.dao.LivingDao;
import com.yunplayer.model.LivingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LivingService {
	@Autowired
	private LivingDao livingDao;

	public List<LivingModel> getAllLivings(){
		return livingDao.getAllLivings();
	}

	public LivingModel getLiving(String id) {
		return livingDao.getLiving(id);
	}

	boolean addLiving(LivingModel liveModel) {
		return livingDao.addLiving(liveModel);
	}

	boolean updateLiving(String id, String liveid) {
		return livingDao.updateLiving(id, liveid);
	}

	boolean deleteLiving(String id) {
		return livingDao.deleteLiving(id);
	}
}
