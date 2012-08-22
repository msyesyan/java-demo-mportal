package com.bStar.mportal.service;

import java.util.List;

import com.bStar.mportal.dao.EventDao;
import com.bStar.mportal.dao.EventDaoJdbcImpl;
import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.Event;

public class EventServiceImpl implements EventService {

	private EventDao eventDao = new EventDaoJdbcImpl();
	public void save(Event event,List<Channel>channels) throws Exception {
		eventDao.save(event);
		System.out.println("evnetService "+event.getEgpProduction().getLanguage());
		System.out.println("eventService"+event.getEgpProduction().getShortDescription());
		for(int i = 0;i<channels.size();i++){
			eventDao.saveChannel(event.getEventId(),channels.get(i));
		}
		
	}
	

}
