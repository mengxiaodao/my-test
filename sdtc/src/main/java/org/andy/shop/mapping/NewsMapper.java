package org.andy.shop.mapping;

import org.andy.shop.model.SysUser;
import org.andy.shop.model.dto.NewsDto;
import org.andy.shop.model.dto.SysUserDto;
import org.andy.shop.model.vo.NewsVo;
import org.andy.shop.model.vo.SysUserVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "newsMapper")
public interface NewsMapper {

    /**
     * dto查询列表
	 * @param dto
     * @return
     */
	List<NewsVo> getNewsByDto(NewsDto dto);

    /**
     * dto统计用户条数
	 * @param dto
     * @return
     */
	Integer countNewsByDto(NewsDto dto);

    /**
     * 保存后台用户
	 * @param dto
	 */
	Integer insertSelective(NewsDto dto);

    /**
     * 删除用户
	 * @param id
     * @return
     */
	Integer deleteNewsById(Long id);
}
