package org.andy.shop.mapping;

import java.util.List;

import org.andy.shop.model.User;

public interface UserMapper {
	//获取所有用户
	List<User> getAllUsers();
}
