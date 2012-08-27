package com.bstar.mportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.ObjectUtils;

@Entity
public class Category {
	
	@Id @GeneratedValue
	private Integer id;
	private String name;

	// private List<Channel>channels;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Category) {
			Category other = (Category) obj;
			return this.getId() != null && ObjectUtils.equals(this.getId(), other.getId());
		}
		
		return false;
	}
	
}
