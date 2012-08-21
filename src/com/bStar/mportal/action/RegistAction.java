package com.bStar.mportal.action;

import com.bStar.mportal.pojo.User;
import com.bStar.mportal.service.UserService;
import com.bStar.mportal.service.UserServiceImpl;

public class RegistAction{
	
	//input 
	private User user;
	private UserService userService = new UserServiceImpl();
	public String execute(){
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
