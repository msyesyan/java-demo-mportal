package com.bstar.mportal.action.admin.channels;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Channel;

@Action("")
@Result(location="/WEB-INF/views/admin/channels/index.jsp")
public class IndexAction extends BaseAction {
	
	private static final long serialVersionUID = 5601236845903717102L;
	private List<Channel> channels;
	
	public String execute() throws Exception {
		channels = channelService.findAll();
		return SUCCESS;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
}
