package org.andy.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.andy.shop.mapping.SysUserMapper;
import org.andy.shop.model.SysUser;
import org.andy.shop.service.UserService;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private SysUserMapper sysUserMapper;
	
	//获取所有用户list
	@Override
	public List<SysUser> getAllUsers() {
		return sysUserMapper.getAllUsers();
	}
	// 根据用户名userName，查询用户
	@Override
	public SysUser getUserByUserName(String userName) {
		return sysUserMapper.getUserByUserName(userName);
	}

}
