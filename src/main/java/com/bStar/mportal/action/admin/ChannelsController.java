package com.bStar.mportal.action.admin;

import java.util.List;

import com.bStar.mportal.action.BaseAction;
import com.bStar.mportal.model.Channel;
import com.bStar.mportal.service.ChannelService;

public class ChannelsController extends BaseAction {

	// index param
	private int categoryId;
	private List<Channel> channels;
	// create param
	private int id;
	private String name;
	private int num;
	private String logoUrl;
	private String resourceTU;
	private String programsEndPoint;
	private String categoryName;
	//delete
	
	// service
	private ChannelService channelService = new ChannelService();

	public String index() throws Exception {
		System.out.println("enterChannelAction");
		channels = channelService.findAll();
		return "success";
	}

	public String create() throws NumberFormatException, Exception {

		System.out.println("newChannelAction");
		if (request.getMethod().equals("GET")) {
			return "new";
		}
		System.out.println("newChannelActionNotGet");
		Channel channel = new Channel();
		channel.setName(name);
		channel.setNum(num);
		channel.setLogo(logoUrl);
		
		channelService.save(channel);
		return "create";
	}
	
	public String destroy()throws Exception {
		System.out.println("deleteAction");
		Channel channel = channelService.findById(id);
		if(channelService.delete(channel)){
			return "destroy";
		}
		return "destroyed";
	}
	
	public String edit()throws Exception {
		System.out.println("editAction");
		if(request.getMethod().equals("GET")){
			return "edit";
		}
		System.out.println("id");
		Channel channel = new Channel();
		System.out.println(logoUrl+" "+name+" "+num);
		channel.setLogo(logoUrl);
		channel.setName(name);
		channel.setNum(num);
		channel.setId(id);
		channelService.edit(channel);
		return "edited";
		
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getResourceTU() {
		return resourceTU;
	}

	public void setResourceTU(String resourceTU) {
		this.resourceTU = resourceTU;
	}

	public String getProgramsEndPoint() {
		return programsEndPoint;
	}

	public void setProgramsEndPoint(String programsEndPoint) {
		this.programsEndPoint = programsEndPoint;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
