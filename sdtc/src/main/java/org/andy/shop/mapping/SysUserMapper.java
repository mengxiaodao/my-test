package org.andy.shop.mapping;

import java.util.List;

import org.andy.shop.model.SysUser;
import org.andy.shop.model.dto.SysUserDto;
import org.andy.shop.model.vo.SysUserVo;
import org.springframework.stereotype.Component;

@Component(value = "sysUserMapper")
public interface SysUserMapper {
	/**
	 * 获取所有用户
	 * @return
	 */
	List<SysUser> getAllUsers();
	/**
	*@autho mc
	*@date 2017年9月16日 下午7:07:59 
	*@Description: 根据用户名userName，获取用户
	 */
	SysUser getUserByUserName(String userName);

	/**
	 * dto查询资源列表
	 * @param dto
	 * @return
	 */
	List<SysUserVo> getUsersByDto(SysUserDto dto);

	/**
	 * dto统计用户条数
	 * @param dto
	 * @return
	 */
	Integer countUsersByDto(SysUserDto dto);

	/**
	 * 保存后台用户
	 * @param dto
	 */
	Integer insertSelective(SysUserDto dto);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	Integer deleteSysUserById(Long  id );
}
