package com.yunplayer.dao;

import com.yunplayer.model.LiveModel;

import java.util.List;

public interface LiveDao {
	List<LiveModel> getAllLives();
	LiveModel getLive(String id);
	boolean addLive(LiveModel liveModel);
	boolean updateLive(String id, String name);
	boolean deleteLive(String id);
}
