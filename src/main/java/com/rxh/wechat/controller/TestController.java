package com.rxh.wechat.controller;

import com.rxh.complat.common.util.JsonResult;
import com.rxh.complat.common.util.RedisUtil;
import com.rxh.complat.common.exception.CustomizeException;
import com.rxh.wechat.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/10/9 11:42
 *
 */
@RestController
public class TestController {



    @GetMapping(value = "qw")
    public JsonResult getM(String msg) throws CustomizeException {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("name", "tom");
        hashMap.put("age", "123");

        int i = 1 / 0;

        return new JsonResult().set(200, hashMap, msg);
    }

    @Autowired
    RedisUtil redisUtil;

//    @GetMapping(value = "add")
    public JsonResult redisadd(String msg, HttpServletRequest request) throws CustomizeException {
        HttpSession session = request.getSession();
        session.setAttribute("hello", "12312132");
        return new JsonResult(200);
    }

    @GetMapping(value = "get")
    public JsonResult get(String msg, HttpServletRequest request) throws CustomizeException {
        HttpSession session = request.getSession();
        return new JsonResult().set(200, session.getAttribute("hello").toString());
    }



    @Autowired
    private SysUserService userService;


}
