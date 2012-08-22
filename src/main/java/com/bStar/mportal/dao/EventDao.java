package com.bStar.mportal.dao;

import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.Event;

public interface EventDao {
	void save(Event event)throws Exception;

	void saveChannel(int eventId,Channel channel)throws Exception;
	
	
}
