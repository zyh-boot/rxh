package com.rxh.wechat.common.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 *
 * @Description: 日志代理类
 * @Author Zhang YuHui 
 * @Date 2020/9/30 14:50
 *
 */
@Aspect
//@Component
@Slf4j
public class LogAspect {

    /**
     *
     * @Description 监听service实现类操作
     * @author Zhang YuHui
     * @date 2020/9/30 15:57
     * @param
     * @return
     */
    @Pointcut("execution(* com.rxh.wechat.service.impl..*.*(..)) ")
    public void pointCutPackage() {
    }

    /**
     *
     * @Description 监听使用自定义@Log注解的方法执行
     * @author Zhang YuHui
     * @date 2020/9/30 15:58
     * @param
     * @return
     */
    @Pointcut("@annotation(com.rxh.wechat.common.annotation.Log)")
    public void pointCutAnnotation() {
    }

    ;

    @Around("pointCutPackage() || pointCutAnnotation()")
    public void logHandler(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        Object[] args = point.getArgs();

        StringBuilder builder = new StringBuilder();
        for (Object object : args) {
            builder.append(object);
        }

        try {
            point.proceed();
            long mills = System.currentTimeMillis() - start;
            log.info("请求成功 请求时间：{}，请求耗时：{}，请求类名：{}，请求方法：{}，请求参数:{}，请求结果：{}", LocalDateTime.now(), mills, className, methodName, builder.toString());
        } catch (Exception throwable) {
            String exception = throwable.getClass() + ":" + throwable.getMessage();
            long mills = System.currentTimeMillis() - start;
            log.error("请求失败 失败原因：{}, 请求路径：{}，，请求参数:{}，请求时间：{}，请求耗时：{}", exception, className + "." + methodName, builder.toString(), LocalDateTime.now(), mills);
            throw throwable;
        }

    }

}
