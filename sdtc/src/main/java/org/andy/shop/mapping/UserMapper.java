package org.andy.shop.mapping;

import java.util.List;

import org.andy.shop.model.User;

public interface UserMapper {
	//获取所有用户
	List<User> getAllUsers();
	/**
	*@autho mc
	*@date 2017年9月16日 下午7:07:59 
	*@Description: 根据用户名userName，获取用户
	 */
	User getUserByUserName(String userName);
}
