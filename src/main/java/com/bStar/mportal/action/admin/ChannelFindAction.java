package com.bStar.mportal.action.admin;

import java.util.List;

import com.bStar.mportal.model.Channel;
import com.bStar.mportal.service.ChannelService;

public class ChannelFindAction {
	
	List<Channel>channels;
	ChannelService channelService = new ChannelService();
	public String execute(){
		try {
			channels = channelService.findAll();
			System.out.println("channels.size()"+channels.size());
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
	
}
