package org.andy.shop.service.redisUtil;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 操作 hash 的基本操作
 * Created by mengchuang on 2018/2/24.
 *
 * redisTemplate.opsForValue();//操作字符串
 redisTemplate.opsForHash();//操作hash
 redisTemplate.opsForList();//操作list
 redisTemplate.opsForSet();//操作set
 redisTemplate.opsForZSet();//操作有序set
 */
@Component("redisCache")
public class RedisCacheUtil {
    @Resource
    private RedisTemplate redisTemplate;

    /**
     *向redis中添加hashMap对象
     * @param key  key值
     * @param addMapObj  添加的map对象
     */
    public void addMap(String key, Map<String,Object> addMapObj) {
        if(key == null || "".equals(key)){
            return ;
        }
        redisTemplate.opsForHash().putAll(key, addMapObj);
    }
    /**
     * 删除给定key值的哈希hashKeys
     * @param key
     * @param hashKey
     */
    public void delHashKey(String key, String hashKey) {
        if(key == null || "".equals(key)){
            return;
        }
        redisTemplate.opsForHash().delete(key, hashKey);
    }
    /**
     * 判断给定key值的哈希hashKey是否存在
     * @param key
     * @param hashKey
     * @return
     */
    public boolean existHashKey(String key, String hashKey){
        if(key == null || "".equals(key)){
            return false;
        }
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }
    /**
     * 从redis中取出给定key的hashKey的值
     * @param key
     * @param hashKey
     * @return
     */
    public String getHashKey(String key, String hashKey){
        if(key == null || "".equals(key)){
            return null;
        }
        return (String) redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * 通过给定的num增加散列hashKey的值（整型）
     * @param key
     * @param hashKey
     * @param num 增加的数量
     */
    public void incrementHashKey(String key, String hashKey,Long num) {
        if(key == null || "".equals(key)){
            return;
        }
        redisTemplate.opsForHash().increment(key, hashKey,num);
    }

    /**
     * 向Hash中添加值
     * @param key      可以对应数据库中的表名
     * @param hashKey    可以对应数据库表中的唯一索引
     * @param value    存入redis中的值
     */
    public void hset(String key, String hashKey, String value) {
        if(key == null || "".equals(key)){
            return ;
        }
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * 查询 key中对应多少条数据
     * @param key
     * @return
     */
    public long hsize(String key) {
        if(key == null || "".equals(key)){
            return 0L;
        }
        return redisTemplate.opsForHash().size(key);
    }


}
