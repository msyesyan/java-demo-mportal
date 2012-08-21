package com.bStar.mportal.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.json.JSONArray;

import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.ChannelJson;
import com.bStar.mportal.service.ChannelService;
import com.bStar.mportal.service.ChannelServiceImpl;

public class ChannelListAction {
	
	ChannelService channelService = new ChannelServiceImpl();
	List<Channel>channels ;
	String channelsString ;
	public String execute(){
		try {
			channels = channelService.findAll();
			ChannelJson channelJson = new ChannelJson();
			channelJson.setChannels(channels);
			channelJson.setLast_updated_at(new SimpleDateFormat("yyyy-mm-dd HH:ss:mm+08").format(System.currentTimeMillis()));
			channelsString = JSONArray.fromObject(channelJson).toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	public String getChannelsString() {
		return channelsString;
	}
	public void setChannelsString(String channelsString) {
		this.channelsString = channelsString;
	}
	
	
}
