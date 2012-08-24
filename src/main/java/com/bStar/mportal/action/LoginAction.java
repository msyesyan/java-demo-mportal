package com.bstar.mportal.action;

import org.springframework.stereotype.Controller;

import com.bstar.mportal.action.BaseAction;
import com.bstar.mportal.model.User;
import com.bstar.mportal.service.UserService;

@Controller
public class LoginAction extends BaseAction {
	 
	private static final long serialVersionUID = 3978190073352318498L;
	// input
	private String name;
	private String password;

	private UserService userService = new UserService();

	public String execute() throws Exception {
		
		System.out.println("enterLoginAction");

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
