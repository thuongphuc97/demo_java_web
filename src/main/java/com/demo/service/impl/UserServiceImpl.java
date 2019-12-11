package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.model.User;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUser(String uid) {
		userDao.deleteUser(uid);
	}

	public User getUserById(String id) {
		return userDao.getUserById(id);
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}

}
