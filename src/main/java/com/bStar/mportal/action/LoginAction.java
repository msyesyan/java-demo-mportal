package com.bStar.mportal.action;

import com.bStar.mportal.action.BaseAction;
import com.bStar.mportal.model.User;
import com.bStar.mportal.service.UserService;

public class LoginAction extends BaseAction {
	// input
	private String name;
	private String password;

	private UserService userService = new UserService();

	public String execute() throws Exception {

		if (request.getMethod().equals("POST")) {
			User user = userService.findByName(name);
			if (user != null) {
				if (user.getPassword().equals(password)) {
					return "success";
				}
			}
		}
		System.out.println("input");
		return "input";
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
