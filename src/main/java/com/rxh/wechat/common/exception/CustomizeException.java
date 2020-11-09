package com.rxh.wechat.common.exception;

import java.io.Serializable;

/**
 *
 * @Description: 自定义异常
 * @Author Zhang YuHui 
 * @Date 2020/10/9 16:53
 *
 */
public class CustomizeException extends Exception implements Serializable {

    public CustomizeException(String message) {
        super(message);
    }

}
