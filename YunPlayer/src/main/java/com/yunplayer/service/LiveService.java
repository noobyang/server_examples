package com.yunplayer.service;

import com.yunplayer.dao.LiveDao;
import com.yunplayer.model.LiveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LiveService {
	@Autowired
	private LiveDao liveDao;

	public List<LiveModel> getAllLives(){
		return liveDao.getAllLives();
	}

	public LiveModel getLive(String id) {
		return liveDao.getLive(id);
	}

	boolean addLive(LiveModel liveModel) {
		return liveDao.addLive(liveModel);
	}

	boolean updateLive(String id, String name) {
		return liveDao.updateLive(id, name);
	}

	boolean deleteLive(String id) {
		return liveDao.deleteLive(id);
	}
}
