package com.rxh.onlineStore.controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/11/16 16:22
 *
 */
@RestController
public class TestControllerDemo {
    @RequestMapping("test")
    public Object test(){
        String s = "[{\"id\":\"745DC7A2E89A598C04509CDC6E8FCB60\",\"leadServiceUnid\":\"745DC7A2E89A598C04509CDC6E8FCB60\",\"classOne\":\"公积金一件事\",\"classTwo\":\"公积金一件事\"" +
                ",'title':'退休提取住房公积金张予辉'}]";
        List<String> strings = JSONArray.parseArray(s, String.class);
        return strings;
    }
}
