package com.rxh.wechat.controller;

import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.JsonResult;
import com.rxh.complat.common.util.RedisUtil;
import com.rxh.wechat.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 *
 * @Description: 登录映射
 * @Author Zhang YuHui 
 * @Date 2020/11/5 9:42
 *
 */
@Controller
@Slf4j
public class LoginController {

    @GetMapping("login")
    public String loginView() {
        return "pages/login";
    }

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    SysUserService userService;


    @PostMapping("dologin")
    @ResponseBody
    public JsonResult<Object> doLogin(Member user, boolean rememberMe, HttpServletRequest request) {
        HashMap<String, String> hashMap = new HashMap<>();
        JsonResult<Object> result = new JsonResult<>();

        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            result.message("请输入密码账户");
            return result;
        }

        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
//        subject.getSession().setTimeout(5*1000L);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUsername(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
//            boolean aBoolean = Boolean.getBoolean(erememberMe);
            usernamePasswordToken.setRememberMe(rememberMe);
            subject.login(usernamePasswordToken);
            Member member = (Member) subject.getPrincipal();
            redisUtil.set("user:" + user.getUsername(), member);
        } catch (UnknownAccountException e) {
            log.error("用户名不存在！", e);
            result.message("用户名不存在！");
            return result;
        } catch (AuthenticationException e) {
            log.error("账号或密码错误！", e);
            result.message("账号或密码错误！");
            return result;
        } catch (AuthorizationException e) {
            log.error("没有权限！", e);
            result.message("没有权限");
            return result;
        }
        hashMap.put("url", "home");
        result.success(hashMap).message("login success");
        return result;
    }

    @RequestMapping("logout")
    public void logout(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate();
        sessionStatus.setComplete();
    }

}
