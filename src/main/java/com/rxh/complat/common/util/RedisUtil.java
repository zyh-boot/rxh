package com.rxh.complat.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Description: redis工具类
 * @Author Zhang YuHui 
 * @Date 2020/10/20 10:10
 *
 */
@Component
public class RedisUtil {

    private StringBuffer base = new StringBuffer("rxh:");

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @description: 指定缓存超时时间
     * @author: zyh
     * @date: 2020/11/10
     * @param null
     * @return:
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Description 获取key到期时间
     * @author Zhang YuHui
     * @date 2020/11/10 10:19
     *
     * @params key不为null
     * @return 返回0 永久有效  单位:(秒)
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }


    /**
     * @Description 是否含有key
     * @author Zhang YuHui
     * @date 2020/11/10 10:26
     *
     * @params key
     * @return boolean
     */
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Description 删除
     * @author Zhang YuHui
     * @date 2020/11/10 10:51
     *
     * @params key
     * @return boolean
     */
    public boolean del(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Description 批量删除
     * @author Zhang YuHui
     * @date 2020/11/10 10:52
     *
     * @params key
     * @return boolean
     */
    public boolean delBatch(Collection key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //============================String=============================

    /**
     * @Description 添加缓存
     * @author Zhang YuHui
     * @date 2020/11/10 10:54
     *
     * @params key
     * @params value
     * @params time 缓存失效时间 单位:(秒) time < 0为永久保存
     * @return boolean
     */
    public boolean set(String key, Object value, long... time) {
        try {
            if (time == null || time.length == 0) {
                redisTemplate.opsForValue().set(base.append(key).toString(), value);
            } else {
                redisTemplate.opsForValue().set(base.append(key).toString(), value, time[0], TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Description 获取缓存
     * @author Zhang YuHui
     * @date 2020/11/10 10:56
     *
     * @params key
     * @return java.lang.Object
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    //===============================Map====================================

    /**
     * @Description Hash获取缓存
     * @author Zhang YuHui
     * @date 2020/11/10 10:59
     *
     * @params key 不为 null
     * @params item 为空时,返回key下所有键值对. 不为空时,返回对应的键值
     * @return java.lang.Object
     */
    public Object hGet(String key, String... item) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        if (item == null) {
            return redisTemplate.opsForHash().entries(key);
        }
        for (String str : item) {
            hashMap.put(str, redisTemplate.opsForHash().get(key, str));
        }
        return hashMap;
    }

    /**
     * @Description hmSet 新建map缓存
     * @author Zhang YuHui
     * @date 2020/11/10 11:20
     *
     * @params key
     * @params item
     * @return boolean
     */
    public boolean hmSet(String key, Map item) {
        try {
            redisTemplate.opsForHash().putAll(key, item);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Description hmSet 添加失效时间
     * @author Zhang YuHui
     * @date 2020/11/10 11:21
     *
     * @params key
     * @params item
     * @params time 时间 单位:(秒)
     * @return boolean
     */
    public boolean hmSet(String key, Map item, long time) {
        try {
            redisTemplate.opsForHash().putAll(key, item);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Description hSet向已存在的map里追加
     * @author Zhang YuHui
     * @date 2020/11/10 11:22
     *
     * @params key
     * @params item
     * @params value
     * @return boolean
     */
    public boolean hSet(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @Description hSet向已存在的map里追加
     * @author Zhang YuHui
     * @date 2020/11/10 11:22
     *
     * @params key
     * @params item
     * @params value
     * @params time 覆盖原有缓存中的事件
     * @return boolean
     */
    public boolean hSet(String key, String item, Object value, long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 删除hash表中的值
     * @param key 键 不能为null
     * @param item 项 可以使多个 不能为null
     */
    public void hdel(String key, Object... item) {
        redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 判断hash表中是否有该项的值
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }
}
