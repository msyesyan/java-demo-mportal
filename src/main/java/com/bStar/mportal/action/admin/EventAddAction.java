package com.bStar.mportal.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.bStar.mportal.model.Channel;
import com.bStar.mportal.model.EgpProduction;
import com.bStar.mportal.model.Event;
import com.bStar.mportal.service.ChannelService;
import com.bStar.mportal.service.EventService;
import com.bStar.mportal.util.DateUtil;

public class EventAddAction {
	
	//input
	private String channelIdString;
	private String beginTime;
	private String duration;
	private int id;
	private String type;
	private String language;
	private String name;
	private String shortDescription;
	//
	private EventService eventService = new EventService();
	private ChannelService channelService = new ChannelService();
	public String execute(){
		Event event = new Event();
		EgpProduction egp = new EgpProduction();
		try {
			//2011-09-09T05:16:00+08
			
			System.out.println("egp"+name);
			event.setEventId(id);
			event.setEventBeginTime(DateUtil.parseDate(beginTime));
			event.setEventDuration(Long.parseLong(duration));
			egp.setLanguage(language);
			egp.setName(name);
			egp.setShortDescription(shortDescription);
			event.setEgpProduction(egp);
			System.out.println(event.getEgpProduction().getName());
			String [] channelStrings = channelIdString.split("&");
			List<Channel>channels = new ArrayList<Channel>();
			for(String str:channelStrings){
				channels.add(channelService.findById(Integer.parseInt(str)));
			}
			eventService.save(event, channels);
			System.out.println(event.getEgpProduction().getName());
			System.out.println("��Ŀ�ύ���");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	public String getChannelIdString() {
		return channelIdString;
	}
	public void setChannelIdString(String channelIdString) {
		this.channelIdString = channelIdString;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	
}
