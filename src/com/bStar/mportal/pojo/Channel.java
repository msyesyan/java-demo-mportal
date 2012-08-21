package com.bStar.mportal.pojo;

public class Channel {
	
	private int channelId;
	private int num;//ÆµµÀºÅ
	private long updated_at;
	private String logoUrl;
	private String resourcesType;
	private String resourcesUrl;
	private String programsEndPoint;
	private String name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
