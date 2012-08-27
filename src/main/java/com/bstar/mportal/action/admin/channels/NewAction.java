package com.bstar.mportal.action.admin.channels;

import org.apache.struts2.convention.annotation.Action;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Channel;

@Action
public class NewAction extends BaseAction {
	
	private static final long serialVersionUID = -4937201174820582195L;
	protected Channel channel;
	
	public void prepare() throws Exception {
		channel = new Channel();
	}
	
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
