package com.rxh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author zyh
 */
@SpringBootApplication
@EnableCaching
@EnableJms
@MapperScan(basePackages = {"com.rxh.wechat.mapper","com.rxh.onlineStore.mapper"})
public class WeChatAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeChatAppApplication.class, args);
    }

}
