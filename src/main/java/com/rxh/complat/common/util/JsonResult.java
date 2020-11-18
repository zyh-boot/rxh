package com.rxh.complat.common.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @Description: 后台返回结果类
 * @Author Zhang YuHui 
 * @Date 2020/9/30 16:13
 *
 */
@Data
public class JsonResult<T> {

    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回状态信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public JsonResult() {
    }

    public JsonResult(T data) {
        this.data = data;
    }

    public JsonResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public JsonResult(HttpStatus code, String msg, T data) {
        this.code = code.value();
        if (StringUtils.isNotBlank(msg)){
            this.msg = msg;
        }else{
            this.msg = code.getReasonPhrase();
        }
        this.data = data;
    }

    public JsonResult data(T data){
        this.data = data;
        return this;
    }

    public  JsonResult code(HttpStatus code){
        this.code = code.value();
        this.msg = code.getReasonPhrase();
        return this;
    }

    public JsonResult code(Integer code) {
        this.code = code;
        return this;
    }


    public  JsonResult message(String message) {
        this.msg = message;
        return this;
    }


    public JsonResult set(Integer code,T data,String ...msg){
        this.code = code;
        this.data = data;
        this.msg = getString(msg);
        return this;
    }

    public JsonResult set(HttpStatus code,T data,String ...msg){
        this.code = code.value();
        this.data = data;
        this.msg = getString(msg);
        return this;
    }

    public JsonResult success(T data){
        this.code = HttpStatus.OK.value();
        this.msg = "请求成功!";
        if(StringUtils.isNotBlank(data.toString())){
            this.data = data;
        }
        return this;
    }

    public JsonResult serverError() {
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.msg = "服务器错误!";
        this.data = (T) new ArrayList<T>();
        return this;
    }
    public JsonResult error() {
        this.code = HttpStatus.NO_CONTENT.value();
        this.msg = "资源不存在!";
        return this;
    }

    public static JsonResult filed(HttpStatus code, String message) {
        JsonResult jsonResult = new JsonResult(new HashMap<>()).code(code).message(message);
        return jsonResult;
    }
    public static JsonResult filed(Integer code, String message) {
        JsonResult jsonResult = new JsonResult(new HashMap<>()).code(code).message(message);
        return jsonResult;
    }

    private String getString(String ...prams){
        StringBuffer stringBuffer = new StringBuffer();
        for(String str : prams){
            stringBuffer.append(str);
        }

        return stringBuffer.toString();
    }

}
