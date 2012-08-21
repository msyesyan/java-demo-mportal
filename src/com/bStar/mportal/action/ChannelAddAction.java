package com.bStar.mportal.action;

import java.util.ArrayList;
import java.util.List;

import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.Resource;
import com.bStar.mportal.service.CategoryService;
import com.bStar.mportal.service.CategoryServiceImpl;
import com.bStar.mportal.service.ChannelService;
import com.bStar.mportal.service.ChannelServiceImpl;

public class ChannelAddAction {

	private int id;
	private String name;
	private int num;
	private String logoUrl;
	private String resourceTU;
	private String programsEndPoint;
	private String categoryName;
	private ChannelService channelService = new ChannelServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl(); 

	public String execute() {

		Channel channel = new Channel();
		List<Resource>resources = new ArrayList<Resource>();
		
		try {
			System.out.println("ResourceTU "+resourceTU);
			String resourceStr[] = resourceTU.split("-");
			
			for(int i = 0;i<resourceStr.length;i++){
				String resource[]=resourceStr[i].split("#");
				Resource re = new Resource();
				re.setType(resource[0]);
				re.setUrl(resource[1]);
				resources.add(re);
			}
			channel.setChannelId(id);
			channel.setName(name);
			channel.setNum(num);
			channel.setLogoUrl(logoUrl);
			channel.setProgramsEndPoint(programsEndPoint);
			channel.setUpdated_at(System.currentTimeMillis());
			channel.setResouces(resources);
			
			String[] str = categoryName.split("&");
			for(int i = 0;i<str.length;i++){
				categoryService.addChannel(Integer.parseInt(str[i]), channel);
			}
			channelService.save(channel,resources);
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
