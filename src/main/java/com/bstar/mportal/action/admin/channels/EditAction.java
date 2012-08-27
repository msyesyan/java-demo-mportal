package com.bstar.mportal.action.admin.channels;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.bind.ServletRequestUtils;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.Channel;

@Action
public class EditAction extends BaseAction {
	
	private static final long serialVersionUID = -5026918882494313954L;
	protected Channel channel;
	protected String logoFileName;
	protected File logo;
	public void prepare() throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "id");
		channel = channelService.find(id);
		System.out.println("channelEdit "+channel.getLogo());
	}
	
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getLogoFileName() {
		return logoFileName;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}
	
	
}
