package org.andy.shop.service;

import java.util.List;

import org.andy.shop.model.User;
public interface UserService {
	/**
	 * 获取所有用户list
	 */
	public List<User> getAllUsers();
}
