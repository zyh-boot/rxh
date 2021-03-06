package com.rxh;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author zyh
 */
@SpringBootApplication
//开启缓存
@EnableCaching
//开启MQ
@EnableJms
//Mybatis扫描包
//@MapperScan(basePackages = {"com.rxh.wechat.mapper","com.rxh.onlineStore.mapper"})
@MapperScan(basePackages = {"com.rxh.*.mapper"})
@NacosPropertySource(dataId = "blog", autoRefreshed = true)
public class WeChatAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeChatAppApplication.class, args);
    }

}
