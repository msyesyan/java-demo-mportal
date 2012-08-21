package com.bStar.mportal.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.bStar.mportal.pojo.Category;
import com.bStar.mportal.pojo.Channel;
import com.bStar.mportal.pojo.Resource;
import com.bStar.mportal.service.CategoryService;
import com.bStar.mportal.service.CategoryServiceImpl;
import com.bStar.mportal.service.ChannelService;
import com.bStar.mportal.service.ChannelServiceImpl;

public class ChannelPlayAction {
	//input
	private int channelId;
	//output
	private String channelString;
	private ChannelService channelService = new ChannelServiceImpl();
	private CategoryService categoryService = new CategoryServiceImpl();
	public String execute(){
		try {
			System.out.println(channelId);
			Channel ch = channelService.findById(channelId);
			List<Resource>resources = channelService.findResourceByChannelId(channelId);
			List<Category>categorys = new ArrayList<Category>();
			categorys = categoryService.findByChannelId(channelId);
			List<String>categorysName = new ArrayList<String>();
			for(Category ca:categorys){
				categorysName.add(ca.getCategoryName());
			}
			ch.setCategorys(categorysName);
			JSONArray jsonArray = JSONArray.fromObject(ch);
			channelString = jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getChannelString() {
		return channelString;
	}
	public void setChannelString(String channelString) {
		this.channelString = channelString;
	}
	
	
}
