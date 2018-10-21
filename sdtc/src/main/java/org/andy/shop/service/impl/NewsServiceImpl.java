package org.andy.shop.service.impl;

import org.andy.shop.mapping.NewsMapper;
import org.andy.shop.model.dto.NewsDto;
import org.andy.shop.model.vo.NewsVo;
import org.andy.shop.model.vo.SysUserVo;
import org.andy.shop.service.NewsService;
import org.andy.shop.utils.DateUtil;
import org.andy.shop.utils.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by mengchuang on 2018/10/21
 **/
@Service("newsService")
public class NewsServiceImpl implements NewsService{

    @Resource
    private NewsMapper newsMapper;
    /**
     * 分页查询新闻列表
     * @param dto
     * @return
     */
    @Override
    public Pagination<NewsVo> getNewsByDto(NewsDto dto) {
        Pagination<NewsVo> pagination = new Pagination<>();
        Integer count = newsMapper.countNewsByDto(dto);
        if (count == 0) {
            pagination.setTotal(count);
            return pagination;
        }
        List<NewsVo> newsVos = newsMapper.getNewsByDto(dto);
        //返回列表
        pagination.setRows(newsVos);
        //总条数
        pagination.setTotal(count);
        return pagination;
    }

    /**
     * 插入新闻对像
     *
     * @param dto
     */
    @Override
    public Integer insertNews(NewsDto dto) {
        //获取当前时间
        Date createTime = DateUtil.convertDateToDate(new Date());
        if (dto != null){
            dto.setCreateTime(createTime);
            Integer row = newsMapper.insertSelective(dto);
            return row;
        }
        return 0;
    }

    /**
     * 根据id删除news
     * @param id
     * @return
     */
    @Override
    public Integer deleteNewsById(Long id) {
        return newsMapper.deleteNewsById(id);
    }
}
