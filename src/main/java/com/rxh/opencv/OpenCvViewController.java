package com.rxh.opencv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @Description: 视图定位
 * @Author Zhang YuHui 
 * @Date 2020/12/7 11:33
 *
 */
@Controller
@RequestMapping("opencv")
public class OpenCvViewController {

    @RequestMapping("index")
    public String getIndex(){
        return "pages/opencv/index";
    }

    @RequestMapping("login")
    public String getIndex1(){
        return "pages/login";
    }
}
