package org.andy.shop.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.andy.shop.mapping.SysUserMapper;
import org.andy.shop.model.SysUser;
import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.dto.SysUserDto;
import org.andy.shop.model.vo.MessageVo;
import org.andy.shop.model.vo.SysUserVo;
import org.andy.shop.service.SysUserService;
import org.andy.shop.utils.DateUtil;
import org.andy.shop.utils.Pagination;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;
@Service
public class SysUserServiceImpl implements SysUserService {
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

	/**
	 * @param dto
	 * @Description: 后台用户管理获取分页列表
	 * @param: @param messageDto
	 * @param: @return
	 * @return: Pagination<MessageVo>
	 * @author: mc
	 */
	@Override
	public Pagination<SysUserVo> getUsersByDto(SysUserDto dto) {
		Pagination<SysUserVo> pagination = new Pagination<>();
		Integer count = sysUserMapper.countUsersByDto(dto);
		if (count == 0) {
			pagination.setTotal(count);
			return pagination;
		}
		List<SysUserVo> sysUserVos = sysUserMapper.getUsersByDto(dto);
		//返回列表
		pagination.setRows(sysUserVos);
		//总条数
		pagination.setTotal(count);
		return pagination;
	}

	/**
	 * 插入用户对像
	 * @param dto
	 */
	@Override
	public Integer insertSysUser(SysUserDto dto) {
		//获取当前时间
		Date createTime = DateUtil.convertDateToDate(new Date());
		if (dto != null){
			dto.setCreateTime(createTime);
			Integer row = sysUserMapper.insertSelective(dto);
			return row;
		}
		return 0;
	}

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@Override
	public Integer deleteSysUserById(Long id) {
		return sysUserMapper.deleteSysUserById(id);
	}
}
