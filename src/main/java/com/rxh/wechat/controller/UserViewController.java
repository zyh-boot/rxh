package com.rxh.wechat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rxh.wechat.common.shiro.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @Description: 视图映射
 * @Author Zhang YuHui 
 * @Date 2020/10/22 17:21
 *
 */
@Controller
public class UserViewController {

    @RequestMapping("home")
    public ModelAndView dad(){
        ModelAndView index = new ModelAndView("index");
        SysUser principal = (SysUser) SecurityUtils.getSubject().getPrincipal();
        index.addObject("data",principal.getUsername());
        return index;
//        return "index";
    }

//    @RequestMapping("login")
//    public String index(User user) {
//        return "pages/login/login";
//    }
}
