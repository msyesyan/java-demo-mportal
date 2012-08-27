package com.bstar.mportal.action.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Channel;

@Action
@Result(type="json", params={ "root", "jsonResult" })
public class ChannelsAction extends BaseAction {
	
	private static final long serialVersionUID = 6934989427458155296L;
	private List<Channel> channels;
	
	public String execute() throws Exception {
		channels = channelService.findAll();
		return SUCCESS;
	}
	
	public Map<String, Object> getJsonResult() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("channels", this.getChannels());
		return result;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
}
