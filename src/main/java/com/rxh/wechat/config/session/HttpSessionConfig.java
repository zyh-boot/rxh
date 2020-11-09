package com.rxh.wechat.config.session;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 *
 * @Description: spring session缓存配置类
 * @Author Zhang YuHui 
 * @Date 2020/10/20 9:51
 *
 */
//@Configuration
//@EnableCaching
////@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400)
//public class HttpSessionConfig {
//
//   @Bean
//    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
//       return new StringRedisTemplate(redisConnectionFactory);
//   }
//
//   @Bean
//    public static ConfigureRedisAction configureRedisAction() {
//       return ConfigureRedisAction.NO_OP;
//   }
//}
