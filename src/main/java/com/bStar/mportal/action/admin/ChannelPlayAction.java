package com.bStar.mportal.action.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import net.sf.json.JSONObject;

import com.bStar.mportal.model.Channel;
import com.bStar.mportal.model.Event;
import com.bStar.mportal.model.PlayNowChannel;
import com.bStar.mportal.service.CategoryService;
import com.bStar.mportal.service.ChannelService;
import com.bStar.mportal.service.EventService;

public class ChannelPlayAction {
	//input
	private int channelId;
	//output
	private String channelPlaying;
	private String channelString;
	private ChannelService channelService = new ChannelService();
	private CategoryService categoryService = new CategoryService();
	private EventService eventService = new EventService();
	public String execute(){
		try {
			System.out.println("channelPlayingAction");
			System.out.println(channelId);
			Channel ch = channelService.findById(channelId);
		/*
			List<Resource>resources = channelService.findResourceByChannelId(channelId);
			List<Category>categorys = new ArrayList<Category>();
			categorys = categoryService.findByChannelId(channelId);
			List<String>categorysName = new ArrayList<String>();
			for(Category ca:categorys){
				categorysName.add(ca.getCategoryName());
			}
			ch.setCategorys(categorysName);
			*/
			List<Event>events=new ArrayList<Event>();
			events = eventService.findByChannelId(ch.getId());
			
			System.out.println(events.size());
			List<Event>pasts = new ArrayList<Event>();
			List<Event>now = new ArrayList<Event>();
			List<Event>future = new ArrayList<Event>();
			Calendar cal = new GregorianCalendar();
			for(Event ev : events){
				long da = ev.getEventBeginTime().getTime()+ev.getEventDuration()-System.currentTimeMillis();
				long f = ev.getEventBeginTime().getTime()-System.currentTimeMillis();
				System.out.println((da>0)+"-"+(f>0)+"-"+ev.getEventBeginTime());
				if(f>=0){
					future.add(ev);
					now.add(ev);
				}else if(da<0){
					pasts.add(ev);
				}else{
					now.add(ev);
				}
			}
			PlayNowChannel playNow = new PlayNowChannel();
			playNow.setChannel(ch);
			playNow.setFuture(future);
			playNow.setNow(now);
			playNow.setPast(pasts);
			//IOUtil.writeJson(new File("channel_playing.json"),playNow);
		
			channelPlaying =JSONObject.fromObject(playNow).toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelString() {
		return channelString;
	}
	public void setChannelString(String channelString) {
		this.channelString = channelString;
	}
	public String getChannelPlaying() {
		return channelPlaying;
	}
	public void setChannelPlaying(String channelPlaying) {
		this.channelPlaying = channelPlaying;
	}
	
	
}
