package com.rxh.complat.common.annotation;

import java.lang.annotation.*;

/**
 *
 * @Description: log接口监听注解
 * @Author Zhang YuHui 
 * @Date 2020/9/30 15:44
 *
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}

