package com.org.meify.service;

import java.util.List;

import com.org.meify.entity.UserBean;

public interface UserService {
	void saveUser(UserBean user);
	
	boolean deleteUser(int id);
	
	boolean updateUser(UserBean user);
	
	UserBean getUserBeanById(int id);
	
	UserBean getUserByName(String userName);
	
	List<UserBean> getAllUsers(int startIndex, int pageSize);	
	
	long getUserNumber();
	
	boolean modifyPasswd(int id, String newPasswd);
}
