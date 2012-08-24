package com.bstar.mportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Channel {
	
	@Id @GeneratedValue
	private Integer id;
	
	private Integer num;
	
	private String name;
	
	private String logo;
	
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
	
}
