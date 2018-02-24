package org.andy.shop.controller;

import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.service.redisUtil.RedisCacheUtil;
import org.andy.shop.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by mengchuang on 2018/2/24.
 */
@Controller
@RequestMapping("/redisTest")
public class RedisTestController {
    @Resource
    private RedisCacheUtil redisCacheUtil;

    /**
     * 向Redis插入数据
     * @param messageDto
     * @return
     */
    @RequestMapping(value="/setRedisDate.do")
    @ResponseBody
    public String  setRedisDate(MessageDto messageDto){
        String key = "123";
        String field = "name";
        String value = "mmmmmcccccc";
        redisCacheUtil.hset(key, field, value);
        return "success";
    }

    @RequestMapping(value="/getRedisDate.do")
    @ResponseBody
    public String  getRedisDate(MessageDto messageDto){
        String result = "";
        String key = "123";
        String field = "name";
        result = redisCacheUtil.hget(key, field);
        return  result;
    }
}
