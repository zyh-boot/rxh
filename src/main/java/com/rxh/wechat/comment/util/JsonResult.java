package com.rxh.wechat.comment.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description: 后台返回结果类
 * @Author Zhang YuHui 
 * @Date 2020/9/30 16:13
 *
 */
@Data
public class JsonResult {

    private Integer code;
    private String msg;
    private Map<Object, Object> data;

    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(Integer code, String msg, Map<Object, Object> map) {
        this.code = code;
        this.msg = msg;
        this.data = map;
    }

    public static JsonResult filed(Integer code, String message) {
        JsonResult jsonResult = new JsonResult(code, message,new HashMap<>());
        return jsonResult;
    }


}
