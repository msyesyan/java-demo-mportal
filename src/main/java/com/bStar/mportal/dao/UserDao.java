package com.bstar.mportal.dao;

import com.bstar.mportal.model.User;

public interface UserDao {
	void save(User user)throws Exception;
	User findByName(String name)throws Exception;
}
