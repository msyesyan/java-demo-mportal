package com.bstar.mportal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Channel {

	@Id
	@GeneratedValue
	private Integer id;

	private Integer num;

	private String name;

	private String logo;

	@ManyToMany
	private List<Category> categories;

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

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}
	
	public List<Integer> getCategoryIds() {
		List<Integer> result = new ArrayList<Integer>();
		for (Category category : this.getCategories()) {
			result.add(category.getId());
		}
		return result;
	}
}
