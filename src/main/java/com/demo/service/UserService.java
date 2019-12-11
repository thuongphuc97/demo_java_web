package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(String uid);
	public User getUserById(String id);
	public List<User> getUserList();
}
