package com.rxh.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.JsonResult;
import com.rxh.complat.reptil.ReptileUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.UUID;

/**
 *
 * @Description: 模板组件
 * @Author Zhang YuHui 
 * @Date 2021/1/11 17:57
 *
 */
@Controller
@RequestMapping("assembly")
@Slf4j
public class AssemblyController {
    @RequestMapping("index")
    public String index() {
        return "pages/assembly/assembly";
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

    @RequestMapping("mkedit")
    public String mkedit() {
        return "pages/assembly/full";
    }


    /**
     * @Description loadFile editormd上传文件
     * @author Zhang YuHui
     * @date 2021/1/13 16:58
     *
     * @params files
     * @params request
     * @return java.lang.Object
     *
     * editor.md返回值格式：
     * {
     *   success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
     *   message : "提示的信息，上传成功或上传失败及错误信息等。",
     *   url     : "图片地址"        // 上传成功时才返回
     * }
     */
    @RequestMapping("mkload")
    @ResponseBody
    public Object loadFile(@RequestParam(value = "editormd-image-file") MultipartFile[] files, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", 0);
        String rootPath = System.getProperty("user.dir");
        String path = rootPath + "/src/main/resources/static/blog/user/";

        Member member = (Member)SecurityUtils.getSubject().getPrincipal();
        for (MultipartFile file : files) {
            log.info(file.getName());
            try {
                String fileName = replaceFileName(files[0].getOriginalFilename());


                boolean file1 = ReptileUtils.createFile(path + member.getId()+"/"+ fileName, file.getBytes());
                if(file1){
                    jsonObject.put("success",1);
                    jsonObject.put("message", "上传成功!");

                    InetAddress localHost = InetAddress.getLocalHost();
                    String ip = localHost.getHostAddress();

                    jsonObject.put("url", "http://"+ip+":9091/static/blog/user/"+ member.getId()+"/"+fileName);
                }else{
                    jsonObject.put("message", "上传失败!");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

    private String replaceFileName(String fileName){
        String substring = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID() + substring;
    }

}
