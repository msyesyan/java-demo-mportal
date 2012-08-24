package com.bStar.mportal.model;

import java.util.List;

public class ChannelJson {
	List<Channel>channels;
	private String last_updated_at;
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	public String getLast_updated_at() {
		return last_updated_at;
	}
	public void setLast_updated_at(String lastUpdatedAt) {
		last_updated_at = lastUpdatedAt;
	}
	
}	
