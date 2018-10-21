package org.andy.shop.mapping;

import java.util.List;

import org.andy.shop.model.SysUser;
import org.springframework.stereotype.Component;

@Component(value = "sysUserMapper")
public interface SysUserMapper {
	//获取所有用户
	List<SysUser> getAllUsers();
	/**
	*@autho mc
	*@date 2017年9月16日 下午7:07:59 
	*@Description: 根据用户名userName，获取用户
	 */
	SysUser getUserByUserName(String userName);
}
