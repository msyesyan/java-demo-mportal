package com.bstar.mportal.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.bstar.mportal.model.User;
import com.bstar.mportal.service.UserService;

@Action
@Result(name="success", location="/admin/channels/index", type="redirect")
public class LoginAction extends BaseAction {
	 
	private static final long serialVersionUID = -3023390698674156560L;
	private @Autowired UserService userService;
	
	// input
	private String name;
	private String password;
	
	
	public String execute() throws Exception {
		if (request.getMethod().equals("POST")) {
			User user = userService.findByName(name);
			if (user != null) {
				if (user.getPassword().equals(password)) {
					return SUCCESS;
				}
			}
		}
		
		return INPUT;
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
