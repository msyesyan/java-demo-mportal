package com.bstar.mportal.action.admin.channels;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.web.bind.ServletRequestUtils;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Channel;

@Action
@Result(type="redirect", location="/admin/channels/")
public class DestroyAction extends BaseAction {
	
	private static final long serialVersionUID = -1320901485040198923L;
	private Channel channel;
	
	public void prepare() throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "id");
		channel = channelService.find(id);
	}
	
	public String execute() throws Exception {
		channelService.delete(channel);
		return SUCCESS;
	}
	
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
}
