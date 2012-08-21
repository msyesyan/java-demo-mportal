package com.bStar.mportal.pojo;

import java.util.List;

public class Channel {
	
	private int channelId;
	private int num;//ÆµµÀºÅ
	private long updated_at;
	private String logoUrl;
	private List<Resource>resources;
	//private String resourcesType;
	//private String resourcesUrl;
	private String programsEndPoint;
	private String name;
	private List<String>categorys;
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public long getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(long updatedAt) {
		updated_at = updatedAt;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getProgramsEndPoint() {
		return programsEndPoint;
	}
	public void setProgramsEndPoint(String programsEndPoint) {
		this.programsEndPoint = programsEndPoint;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<String> categorys) {
		this.categorys = categorys;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResouces(List<Resource> resources) {
		this.resources = resources;
	}
	
	
	
	
}
