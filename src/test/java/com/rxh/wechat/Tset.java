package com.rxh.wechat;

import com.rxh.WeChatAppApplication;
import com.rxh.complat.common.elasticsearch.EsSearchService;
import com.rxh.complat.common.util.Md5Utils;
import com.rxh.complat.common.util.RedisUtil;
import com.rxh.complat.demo.Base64PreFix;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/10/11 15:44
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class Tset {

    @Autowired
    EsSearchService esSearchService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public  void show() throws IOException {
        redisTemplate.opsForValue().set("test123","asdadadasdasd");
    }

    @Test
    public void md5(){
        String s = Md5Utils.md5Encode("中华人民共和国", "");
        System.out.println(s);
    }


}
