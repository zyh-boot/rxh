package com.rxh.complat.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2020/11/30 14:31
 *
 */
@Controller
public class ImgController {

    @RequestMapping("imgPage")
    public String as(){
        return "pages/img";
    }
}
