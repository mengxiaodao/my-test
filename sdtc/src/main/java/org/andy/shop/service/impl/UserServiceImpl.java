package org.andy.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.andy.shop.mapping.UserMapper;
import org.andy.shop.model.User;
import org.andy.shop.service.UserService;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	
	//获取所有用户list
	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}
	// 根据用户名userName，查询用户
	@Override
	public User getUserByUserName(String userName) {
		return userMapper.getUserByUserName(userName);
	}

}
