package com.bStar.mportal.dao;

import com.bStar.mportal.pojo.User;

public interface UserDao {
	void save(User user)throws Exception;
	User findByName(String name)throws Exception;
}
