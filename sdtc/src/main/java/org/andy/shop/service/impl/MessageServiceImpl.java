package org.andy.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.andy.shop.mapping.MessageMapper;
import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.vo.MessageVo;
import org.andy.shop.service.MessageService;
import org.andy.shop.utils.Pagination;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
	@Resource
	private MessageMapper messageMapper;
	
	//资源管理获取分页列表
	@Override
	public Pagination<MessageVo> getMessagesByDto(MessageDto messageDto) {
		Pagination<MessageVo> pagination = new Pagination<MessageVo>();
		Integer count = messageMapper.countMessagesByDto(messageDto);
		if (count == 0) {
			pagination.setTotal(count);
			return pagination;
		}
		List<MessageVo> messageVos = messageMapper.getMessagesByDto(messageDto);
		pagination.setRows(messageVos); //返回列表
		pagination.setTotal(count);//总条数
		return pagination;
	}

}