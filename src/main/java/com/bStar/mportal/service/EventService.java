package com.bStar.mportal.service;

import java.util.List;

import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.Event;

public interface EventService {
	void save(Event event,List<Channel>channels)throws Exception;
}
