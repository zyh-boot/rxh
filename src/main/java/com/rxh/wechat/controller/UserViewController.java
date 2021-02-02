package com.rxh.wechat.controller;

import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public ModelAndView dad() {
        ModelAndView index = new ModelAndView("index");
        Member principal = (Member) SecurityUtils.getSubject().getPrincipal();
        if (principal != null) {
            index.addObject("data", principal.getUsername());
        }
        return index;
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("header")
    public String header() {
        return "pages/complate/header";
    }

    @RequestMapping("test")
    public String test() {
        return "pages/test";
    }
    @RequestMapping("mk")
    public String mk() {
        return "pages/simple";
    }

    @RequestMapping("isLogin")
    @ResponseBody
    public JsonResult<Object> isLogin() {
        JsonResult<Object> result = new JsonResult<>();
        result.code(400);
        Member principal = (Member) SecurityUtils.getSubject().getPrincipal();
        if (principal == null) {
            result.message("未登录");
            result.data("");
        } else {
            result.code(200);
            result.message("登录成功");
            result.data(principal.getUsername());
        }
        return result;
    }


}
