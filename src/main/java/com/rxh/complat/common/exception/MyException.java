package com.rxh.complat.common.exception;

import java.io.Serializable;

/**
 *
 * @Description: 自定义异常
 * @Author Zhang YuHui 
 * @Date 2020/10/9 16:53
 *
 */
public class MyException extends Exception implements Serializable {

    public MyException(String message) {
        super(message);
    }

}
