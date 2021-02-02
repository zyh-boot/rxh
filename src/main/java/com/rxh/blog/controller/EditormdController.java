package com.rxh.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @Description: mk文本编辑器
 * @Author Zhang YuHui 
 * @Date 2021/1/13 9:51
 *
 */
@RestController
@RequestMapping("blog")
public class EditormdController {
    @RequestMapping("mkload")
    public Object loadFile(MultipartFile[] file){
        return null;
    }
}
