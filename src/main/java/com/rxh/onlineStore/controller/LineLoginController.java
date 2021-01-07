package com.rxh.onlineStore.controller;

import com.rxh.complat.common.util.JsonResult;
import com.rxh.complat.common.util.Md5Utils;
import com.rxh.onlineStore.entity.SysUser;
import com.rxh.onlineStore.service.LineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Description: 商城登录
 * @Author Zhang YuHui 
 * @Date 2021/1/6 11:40
 *
 */
@RequestMapping("lineStore")
@RestController
public class LineLoginController {
    @Autowired
    LineUserService lineUserService;

    @RequestMapping("register")
    public Object register(SysUser sysUser){
        JsonResult<Object> result = new JsonResult<>();
        result.setCode(500);
        sysUser.setPassword(Md5Utils.md5Encode(sysUser.getPassword(),null));
        int save = lineUserService.insert(sysUser);
        if(save != 0){
            result.setCode(200);
            result.setMsg("message");
            result.setData("保存成功");
        }
        return result;
    }

}
