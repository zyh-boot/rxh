package com.rxh.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @Description: 模板组件
 * @Author Zhang YuHui 
 * @Date 2021/1/11 17:57
 *
 */
@Controller
@RequestMapping("assembly")
public class AssemblyController {
    @RequestMapping("index")
    public String index(){
        return "pages/assembly/assembly";
    }
}
