package org.andy.shop.mapping;
import java.util.List;

import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.vo.MessageVo;


public interface MessageMapper {
   
    /**
     * @Description: 资源管理查询，分页列表 
     * @param: @param messageDto
     * @param: @return      
     * @return: List<Message>
     * @author: mc
     */
    public List<MessageVo> getMessagesByDto(MessageDto messageDto);
    
    /**
     * @Description: 资源管理查询，总条数 
     * @param: @param messageDto
     * @param: @return      
     * @return: Integer
     * @author: mc
     */
    public Integer countMessagesByDto(MessageDto messageDto);
}