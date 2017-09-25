package org.andy.shop.service;

import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.vo.MessageVo;
import org.andy.shop.utils.Pagination;

public interface MessageService {
	/**
	 * @Description: 资源管理获取分页列表
	 * @param: @param messageDto
	 * @param: @return      
	 * @return: Pagination<MessageVo>
	 * @author: mc
	 */
	public Pagination<MessageVo> getMessagesByDto(MessageDto messageDto);
}
