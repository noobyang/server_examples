package com.yunplayer.dao;

import com.yunplayer.model.LivePrevModel;

import java.util.List;

public interface LivePrevDao {
	List<LivePrevModel> getAllLivePrevs();
	LivePrevModel getLivePrev(String id);
	boolean addLivePrev(LivePrevModel livePrevModel);
	boolean updateLivePrev(String id, String name);
	boolean deleteLivePrev(String id);
}
