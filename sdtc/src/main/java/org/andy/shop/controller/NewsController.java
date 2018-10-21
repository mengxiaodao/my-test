package org.andy.shop.controller;

import org.andy.shop.exception.BusinessException;
import org.andy.shop.model.dto.NewsDto;
import org.andy.shop.model.dto.SysUserDto;
import org.andy.shop.model.vo.NewsVo;
import org.andy.shop.model.vo.SysUserVo;
import org.andy.shop.service.NewsService;
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
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;

    /**
     * 新闻分页列表
     * @param request
     * @return
     */
    @RequestMapping("/pageInit.do")
    public ModelAndView pageInit(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        //返回的文件名
        mav.setViewName("/news/list");
        return mav;
    }
    /**
     * 分页查询新闻
     * @param dto
     * @return
     */
    @RequestMapping(value="/getNewsByDto.do")
    @ResponseBody
    public Pagination<NewsVo> getNewsByDto(NewsDto dto) {
        Pagination<NewsVo> pagination = newsService.getNewsByDto(dto);
        return pagination;
    }

    /**
     * 插入新闻
     * @param dto
     * @return
     */
    @RequestMapping(value="/insertNews.do")
    @ResponseBody
    public Result insertNews(NewsDto dto) {
        Result result = new Result();
        try {
            Integer row = newsService.insertNews(dto);
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
     * 删除新闻by id
     * @param id
     * @return
     */
    @RequestMapping(value="/delete.do")
    @ResponseBody
    public Result delete(Long id) {
        Result result = new Result();
        try {
            newsService.deleteNewsById(id);
            result.set("删除成功", true);
        } catch (BusinessException be) {
            result.set(be.getMessage(), false);
        }
        return result;
    }

}
