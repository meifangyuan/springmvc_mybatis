package com.org.meify.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.meify.dao.UserDao;
import com.org.meify.entity.UserBean;
import com.org.meify.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	
	@Override
	public void saveUser(UserBean user) {
		userDao.insertUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public boolean updateUser(UserBean user) {
		return userDao.updateUser(user);
	}

	@Override
	public UserBean getUserBeanById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<UserBean> getAllUsers(int startIndex, int pageSize) {
		return userDao.getAllUsers(startIndex, pageSize);
	}

	@Override
	public UserBean getUserByName(String userName) {
		return userDao.getUserByName(userName);
	}

	@Override
	public long getUserNumber() {
		return userDao.getUserNum();
	}

	@Override
	public boolean modifyPasswd(int id, String newPasswd) {
		return userDao.modifyPasswd(id, newPasswd);
	}

}
