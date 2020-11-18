package com.rxh.complat.common.exception;

import com.rxh.complat.common.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @Description: 全局异常捕获
 * @Author Zhang YuHui 
 * @Date 2020/9/30 15:59
 *
 */
@CrossOrigin
@RestControllerAdvice
@Slf4j
public class GlobalException {


    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";

    @ExceptionHandler(RuntimeException.class)
    public JsonResult runtimeException(RuntimeException e) {
        return resultFormat(1, "错误信息: 运行异常!" + e.getMessage(), e);
    }

    @ExceptionHandler(IOException.class)
    public JsonResult iOException(IOException e) {
        return resultFormat(2, "错误信息: IO异常!" + e.getMessage(), e);
    }

    @ExceptionHandler(NoSuchMethodException.class)
    public JsonResult noSuchMethodException(NoSuchMethodException e) {
        return resultFormat(3, "错误信息: 方法未找到!" + e.getMessage(), e);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public JsonResult indexOutOfBoundsException(IndexOutOfBoundsException e) {
        return resultFormat(4, "错误信息: 下标越界!" + e.getMessage(), e);
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public JsonResult classNotFoundException(ClassNotFoundException e) {
        return resultFormat(5, "错误信息: 指定类不存在!" + e.getMessage(), e);
    }

    @ExceptionHandler(ArithmeticException.class)
    public JsonResult arithmeticException(ArithmeticException e) {
        return resultFormat(6, "错误信息: 算数异常!" + e.getMessage(), e);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public JsonResult arrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e) {
        return resultFormat(7, "错误信息: 数组下标越界!" + e.getMessage(), e);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public JsonResult fileNotFoundException(FileNotFoundException e) {
        return resultFormat(8, "错误信息: 文件未找到!" + e.getMessage(), e);
    }

    @ExceptionHandler(NumberFormatException.class)
    public JsonResult numberFormatException(NumberFormatException e) {
        return resultFormat(9, "错误信息: 数据格式异常!" + e.getMessage(), e);
    }

    @ExceptionHandler(NullPointerException.class)
    public JsonResult nullPointerException(NullPointerException e) {
        return resultFormat(10, "错误信息: 空指针异常" + e.getMessage(), e);
    }


    @ExceptionHandler({Exception.class})
    public JsonResult otherException(Exception e) {
        return resultFormat(11, "错误信息: 缺省异常!" + e.getMessage(), e);
    }

    @ExceptionHandler
    public JsonResult ErrorHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e);
       return resultFormat(12, "错误信息: 没有通过权限验证!" + e.getMessage(), e);
    }

    @ExceptionHandler(CustomizeException.class)
    public JsonResult customizeException(Exception e) {
        return resultFormat(10001, e.getMessage(), e);
    }

    /**
     *
     * @Description resultFormat
     * @author Zhang YuHui
     * @date 2020/10/5 15:46
     * @param code 自定义异常编号
     * @param message 异常描述
     * @param t 异常泛型类
     * @return com.rxh.wechat.comment.util.JsonResult
     */
    private <T extends Throwable> JsonResult resultFormat(Integer code, String message, T t) {
        t.printStackTrace();
//        log.error(logExceptionFormat,"错误信息: " + e.getMessage(),code,"错误信息: " + e.getMessage(),t.getMessage());
        System.out.println(t.getMessage());
        return JsonResult.filed(code, message);
    }

}
