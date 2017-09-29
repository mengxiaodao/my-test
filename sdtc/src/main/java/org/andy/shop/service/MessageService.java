package org.andy.shop.service;

import org.andy.shop.model.Message;
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
	
	/**
	 * 插入资源对像
	 * @param message
	 */
	public void insertMsg(Message message);
	
	/**
	 * 获取需要导出的总共条数
	 * @param messageDto
	 * @return
	 */
	public Integer getMsgExportCount(MessageDto messageDto);
	
	/**
	 * 根据id删除资源
	 * @param id
	 * @return
	 */
	public Integer deleteMsgById(long id);
}
