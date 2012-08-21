package com.bStar.mportal.action;

import com.bStar.mportal.pojo.User;
import com.bStar.mportal.service.UserService;
import com.bStar.mportal.service.UserServiceImpl;

public class LoginAction {
	//input
	private String name;
	private String password;
	
	private UserService userService = new UserServiceImpl();
	
	public String execute(){
		User user = new User();
		try {
			user = userService.findByName(name);
			if(user!=null){
				if(user.getPassword().equals(password)){
					return "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
