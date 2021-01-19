package com.rxh.complat.common.util;

import com.rxh.complat.common.shiro.entity.Member;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 *
 * @Description: Spring Session工具类
 * @Author Zhang YuHui 
 * @Date 2021/1/14 18:54
 *
 */
public class SessionUtils {

    //获取在线用户
    public static Member getUser(){
        Member principal = (Member) SecurityUtils.getSubject().getPrincipal();
        return principal;
    }
    //获取用户权限
    public static Subject getUserSubject(){
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }
}
