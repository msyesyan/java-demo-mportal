package com.bStar.mportal.service;

import com.bStar.mportal.pojo.User;

public interface UserService {
	void save(User user)throws Exception;
	User findByName(String name)throws Exception;
}
