package com.bStar.mportal.model;

import java.util.List;

public class PlayNowChannel {
	private Channel channel;
	private List<Event>past;
	private List<Event>now;
	private List<Event>future;
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public List<Event> getPast() {
		return past;
	}
	public void setPast(List<Event> past) {
		this.past = past;
	}
	public List<Event> getNow() {
		return now;
	}
	public void setNow(List<Event> now) {
		this.now = now;
	}
	public List<Event> getFuture() {
		return future;
	}
	public void setFuture(List<Event> future) {
		this.future = future;
	}
	
	
}
