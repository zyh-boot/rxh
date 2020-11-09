package com.rxh.wechat.common.util;

import com.rxh.wechat.common.exception.CustomizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 * @Description: redis工具类
 * @Author Zhang YuHui 
 * @Date 2020/10/20 10:10
 *
 */
@Component
public class RedisUtil {

    private  StringBuffer base = new StringBuffer("rxh:");

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(base.append(key).toString(), value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
