package org.andy.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.vo.MessageVo;
import org.andy.shop.service.MessageService;
import org.andy.shop.utils.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/msgManage")
public class MessageController {
	@Resource
	private MessageService messageService;
	
	/**
	*@autho mc
	*@date 2017年9月17日 下午6:41:25 
	*@Description: 展示用户管理列表
	 */
	@RequestMapping("/pageInit.do")
	public ModelAndView  pageInit(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();  
		mav.setViewName("/message/messageList"); //返回的文件名 
		return mav;
	}
	
	/**
	 * @Description: 资源管理获取分页列表
	 * @param: @param messageDto
	 * @param: @return      
	 * @return: Pagination<MessageVo>
	 * @author: mc
	 */
	@RequestMapping(value="/getMsgList.do")
	@ResponseBody
	public Pagination<MessageVo> getMsgList(MessageDto messageDto) {
		Pagination<MessageVo> messPagination = messageService.getMessagesByDto(messageDto);
		return messPagination;
	}
}
