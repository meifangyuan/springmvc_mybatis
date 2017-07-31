package com.org.meify.dao;
import java.util.List;

import com.org.meify.entity.UserBean;


public interface UserDao {

	void insertUser(UserBean user);
	
	boolean deleteUser(int id);
	
	boolean updateUser(UserBean user);
	
	UserBean getUserById(int id);
	
	UserBean getUserByName(String userName);
	
	List<UserBean> getAllUsers(int startIndex, int pageSize);
	
	long getUserNum();
	
	boolean modifyPasswd(int id, String newPasswd);
	
	
}
