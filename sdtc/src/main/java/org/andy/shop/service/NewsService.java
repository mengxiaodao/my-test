package org.andy.shop.service;

import org.andy.shop.model.Message;
import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.model.dto.NewsDto;
import org.andy.shop.model.vo.MessageVo;
import org.andy.shop.model.vo.NewsVo;
import org.andy.shop.utils.Pagination;
import org.springframework.stereotype.Service;


public interface NewsService {
	/**
	 * 分页查询新闻列表
	 * @param dto
	 * @return
	 */
	 Pagination<NewsVo> getNewsByDto(NewsDto dto);
	
	/**
	 * 插入新闻对像
	 * @param dto
	 */
	 Integer insertNews(NewsDto dto);

	
	/**
	 * 根据id删除news
	 * @param id
	 * @return
	 */
	 Integer deleteNewsById(Long id);
}
