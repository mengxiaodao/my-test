package org.andy.shop.controller;

import org.andy.shop.exception.BusinessException;
import org.andy.shop.model.Message;
import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.dto.SysUserDto;
import org.andy.shop.model.vo.MessageVo;
import org.andy.shop.model.vo.SysUserVo;
import org.andy.shop.service.SysUserService;
import org.andy.shop.utils.Pagination;
import org.andy.shop.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by mengchuang on 2018/10/21
 **/
@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    /**
     * 展示资源分页列表
     * @param request
     * @return
     */
    @RequestMapping("/pageInit.do")
    public ModelAndView pageInit(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        //返回的文件名
        mav.setViewName("/sysUser/list");
        return mav;
    }
    /**
     * 分页查询用户
     * @param dto
     * @return
     */
    @RequestMapping(value="/getUsersList.do")
    @ResponseBody
    public Pagination<SysUserVo> getUsersList(SysUserDto dto) {
        Pagination<SysUserVo> pagination = sysUserService.getUsersByDto(dto);
        return pagination;
    }

    /**
     * 插入用户
     * @param dto
     * @return
     */
    @RequestMapping(value="/insertSysUser.do")
    @ResponseBody
    public Result insertSysUser(SysUserDto dto) {
        Result result = new Result();
        try {
            Integer row = sysUserService.insertSysUser(dto);
            if (row > 0 ){
                result.set("插入成功", true);
            }else {
                result.set("插入失败", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.set("插入失败", false);
        }
        return result;
    }
    /**
     * 删除资源by id
     * @param id
     * @return
     */
    @RequestMapping(value="/delete.do")
    @ResponseBody
    public Result delete(Long id) {
        Result result = new Result();
        try {
            sysUserService.deleteSysUserById(id);
            result.set("删除成功", true);
        } catch (BusinessException be) {
            result.set(be.getMessage(), false);
        }
        return result;
    }

}
