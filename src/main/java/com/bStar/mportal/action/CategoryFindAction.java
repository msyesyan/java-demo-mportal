package com.bStar.mportal.action;

import java.util.List;

import com.bStar.mportal.pojo.Category;
import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.service.CategoryService;
import com.bStar.mportal.service.CategoryServiceImpl;
import com.bStar.mportal.service.ChannelService;
import com.bStar.mportal.service.ChannelServiceImpl;

public class CategoryFindAction {
	// input
	private int categoryId;

	private CategoryService categoryService = new CategoryServiceImpl();
	private ChannelService channelService = new ChannelServiceImpl();
	private List<Category> categorys;
	
	public String findCategory(){
		try {
			System.out.println("只是找");
			categorys = categoryService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String execute() {
		try {
			System.out.println("不只是找");
			findCategory();
			for (int i = 0; i < categorys.size(); i++) {
				categorys.get(i).setChannels(
						channelService.findByCategoryId(categorys.get(i)
								.getCategoryId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
