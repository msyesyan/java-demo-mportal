package com.bStar.mportal.model;

import java.util.List;

public class Channel {
	
	private Integer id;
	private Integer num;
	private String name;
	private String logo;
	
	private List<Resource>resources;
	private List<String>categorys;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logoUrl) {
		this.logo = logoUrl;
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
