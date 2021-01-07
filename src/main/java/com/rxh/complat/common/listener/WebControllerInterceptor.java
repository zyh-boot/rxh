package com.rxh.complat.common.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @Description: 全局映射拦截器
 * @Author Zhang YuHui 
 * @Date 2020/12/25 11:47
 *
 */
@Slf4j
public class WebControllerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String methodName = handlerMethod.getMethod().getName();
        String className = handlerMethod.getBean().getClass().getSimpleName();

        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();

        StringBuffer buffer = new StringBuffer();

        while (iterator.hasNext()) {
            Map.Entry<String, String[]> entry = iterator.next();
            String entryKey = entry.getKey();
            Object entryValue = entry.getValue();


            String pramsValue = entryValue.toString();
            if (entryValue instanceof String[]) {
                pramsValue = Arrays.toString((String[]) entryValue);
            }
            buffer.append(entryKey).append("=").append(pramsValue);
        }
        String servletPath = request.getServletPath();
        servletPath = servletPath.substring(servletPath.lastIndexOf("/"));

        boolean b = className.indexOf("LoginController") > -1;


        if (b || servletPath.equals("/newLogin.do") || servletPath.equals("/login.do") || servletPath.equals("/getStatus.do")) {
            log.info("全局拦截器拦截登录请求: 类名:" + className + "方法名:" + methodName + "参数:" + buffer.toString());
            return true;
        }

        //



        return true;
    }

    /**
     * 只有preHandle 返回为true时执行
     *
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {


    }

    /**
     * 拦截器最后操作
     *
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
