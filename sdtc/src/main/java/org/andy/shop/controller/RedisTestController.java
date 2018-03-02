package org.andy.shop.controller;
import org.andy.shop.model.dto.MessageDto;
import org.andy.shop.service.redisUtil.RedisCacheUtil;
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
       /* Map<String, Object> hash1 = new HashMap<>();
        hash1.put("age","1");
        redisCacheUtil.addMap(key,hash1);*/
        redisCacheUtil.incrementHashKey(key,"age",1L);
        return "success";
    }

}
