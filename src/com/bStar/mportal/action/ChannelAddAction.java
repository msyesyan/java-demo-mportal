package com.bStar.mportal.action;

import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.service.CategoryService;
import com.bStar.mportal.service.CategoryServiceImpl;
import com.bStar.mportal.service.ChannelService;
import com.bStar.mportal.service.ChannelServiceImpl;

public class ChannelAddAction {

	private int id;
	private String name;
	private int num;
	private String logoUrl;
	private String resourcesType;
	private String resourcesUrl;
	private String programsEndPoint;
	private String categoryName;
	private ChannelService channelService = new ChannelServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl(); 

	public String execute() {

		Channel channel = new Channel();
		
		try {
			channel.setChannelId(id);
			channel.setName(name);
			channel.setNum(num);
			channel.setResourcesType(resourcesType);
			channel.setResourcesUrl(resourcesUrl);
			channel.setLogoUrl(logoUrl);
			channel.setProgramsEndPoint(programsEndPoint);
			channel.setUpdated_at(System.currentTimeMillis());
			channelService.save(channel);
			String[] str = categoryName.split("&");
			System.out.println("categoryStr[]-"+str);
			for(int i = 0;i<str.length;i++){
				categoryService.addChannel(Integer.parseInt(str[i]), channel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
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

	public String getResourcesType() {
		return resourcesType;
	}

	public void setResourcesType(String resourcesType) {
		this.resourcesType = resourcesType;
	}

	public String getResourcesUrl() {
		return resourcesUrl;
	}

	public void setResourcesUrl(String resourcesUrl) {
		this.resourcesUrl = resourcesUrl;
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
