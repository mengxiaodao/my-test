package org.andy.shop.service;

import java.util.List;

import org.andy.shop.model.User;
public interface UserService {
	/**
	 * 获取所有用户list
	 */
	public List<User> getAllUsers();
	/**
	*@autho mc
	*@date 2017年9月16日 下午7:09:16 
	*@Description: 根据用户名userName，查询用户
	 */
	public User getUserByUserName(String userName);
}
