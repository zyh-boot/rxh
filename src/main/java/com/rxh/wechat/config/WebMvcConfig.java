package com.rxh.wechat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * @Description: springMVC过滤
 * @Author Zhang YuHui 
 * @Date 2020/10/5 16:06
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     *
     * @Description springMVC静态资源过滤
     * @author Zhang YuHui
     * @date 2020/10/11 15:05
     *
     * @param registry
     * @return void
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //原生swagger页面
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/templates/");

        //基于bootstrap-ui的swagger页面
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        //静态资源访问
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     *
     * @Description 配置页面请求视图
     * @author Zhang YuHui
     * @date 2020/10/11 15:09
     *       
     * @param registry
     * @return void
     */
    @Override protected void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("index");
    }
}
