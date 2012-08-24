package com.bStar.mportal.service;

import java.util.List;

import com.bStar.mportal.dao.EventDao;
import com.bStar.mportal.model.Channel;
import com.bStar.mportal.model.Event;

public class EventService {

	private EventDao eventDao = new EventDao();
	public void save(Event event,List<Channel>channels) throws Exception {
		eventDao.save(event);
		System.out.println("evnetService "+event.getEgpProduction().getLanguage());
		System.out.println("eventService"+event.getEgpProduction().getShortDescription());
		for(int i = 0;i<channels.size();i++){
			eventDao.saveChannel(event.getEventId(),channels.get(i));
		}
		
	}
	public List<Event> findByChannelId(int channelId) throws Exception {
		
		return eventDao.findByChannelId(channelId);
	}
	

}
