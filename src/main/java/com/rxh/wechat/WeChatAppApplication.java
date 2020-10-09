package com.rxh.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zyh
 */
@SpringBootApplication
@MapperScan(basePackages = "com.rxh.wechat.mapper")
public class WeChatAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeChatAppApplication.class, args);
    }

}
