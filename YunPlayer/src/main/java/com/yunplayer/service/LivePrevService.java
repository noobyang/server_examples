package com.yunplayer.service;

import com.yunplayer.dao.LivePrevDao;
import com.yunplayer.model.LivePrevModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LivePrevService {
	@Autowired
	private LivePrevDao livePrevDao;

	public List<LivePrevModel> getAllLivePrevs(){
		return livePrevDao.getAllLivePrevs();
	}

	public LivePrevModel getLivePrev(String id) {
		return livePrevDao.getLivePrev(id);
	}

	boolean addLivePrev(LivePrevModel livePrevModel) {
		return livePrevDao.addLivePrev(livePrevModel);
	}

	boolean updateLivePrev(String id, String name) {
		return livePrevDao.updateLivePrev(id, name);
	}

	boolean deleteLivePrev(String id) {
		return livePrevDao.deleteLivePrev(id);
	}
}
