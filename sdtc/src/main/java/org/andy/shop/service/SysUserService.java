package org.andy.shop.service;

import org.andy.shop.model.SysUser;
import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.dto.SysUserDto;
import org.andy.shop.model.vo.MessageVo;
import org.andy.shop.model.vo.SysUserVo;
import org.andy.shop.utils.Pagination;

import java.util.List;

/**
 * Created by mengchuang on 2018/10/21
 **/
public interface SysUserService {
    /**
     * 获取所有用户list
     */
    List<SysUser> getAllUsers();
    /**
     *@autho mc
     *@date 2017年9月16日 下午7:09:16
     *@Description: 根据用户名userName，查询用户
     */
    SysUser getUserByUserName(String userName);

    /**
     * @Description: 后台用户管理获取分页列表
     * @param: @param messageDto
     * @param: @return
     * @return: Pagination<MessageVo>
     * @author: mc
     */
    Pagination<SysUserVo> getUsersByDto(SysUserDto dto);

    /**
     * 插入用户对像
     * @param dto
     */
    Integer insertSysUser(SysUserDto dto);
    /**
     * 删除用户
     * @param id
     * @return
     */
    Integer deleteSysUserById(Long  id );
}
