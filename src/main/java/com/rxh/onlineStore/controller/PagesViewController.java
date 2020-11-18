package com.rxh.onlineStore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户注册页面未制作
 * @Description: 页面跳转映射
 * @Author Zhang YuHui 
 * @Date 2020/11/9 15:30
 *
 */
@Controller
@RequestMapping("shopping")
public class PagesViewController {
    private String basePackage = "pages/onlineStore/";

    /**
     * @description: 通用头部
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("header")
    public String header() {
        return basePackage + "header";
    }

    /**
     * @description: 通用底部
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("footer")
    public String footer() {
        return basePackage + "footer";
    }

    /**
     * @description: 商城主页
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("index")
    public String index() {
        return basePackage + "index";
    }

    @RequestMapping("index2")
    public String index2() {
        return basePackage + "index-2";
    }

    @RequestMapping("index3")
    public String index3() {
        return basePackage + "index-3";
    }

    /**
     * @description: 商城条款信息
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("conditios")
    public String conditios() {
        return basePackage + "terms-conditios";
    }

    /**
     * @description: 用户登录页面
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("login")
    public String login() {
        return basePackage + "my-account";
    }

    /**
     * @description: 用户注册页面
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("register")
    public String register() {
        return basePackage + "my-register";
    }

    /**
     * @description: 进入店铺
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("sidebar")
    public String sidebar() {
        return basePackage + "shop-left-sidebar";
    }

    /**
     * @description: 商品详情
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("details")
    public String details() {
        return basePackage + "shop-details";
    }

    /**
     * @description: 购物车
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("cart")
    public String cart() {
        return basePackage + "cart";
    }

    /**
     * @description: 关于我们
     *               公司详情页面
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("about")
    public String about() {
        return basePackage + "about";
    }

    /**
     * @description: 标准博客
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("blog")
    public String blog() {
        return basePackage + "blog";
    }
    /**
     * @description: 经典博客
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("blog-classic")
    public String blogClassic() {
        return basePackage + "blog-classic";
    }
    /**
     * @description: 博客详情页
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("blog-details")
    public String blogDetails() {
        return basePackage + "blog-details";
    }

    /**
     * @description: 愿望清单
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("wishlist")
    public String wishlist(){
        return basePackage + "wishlist";
    }

    /**
     * @description: 账单详情页面
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("checkout")
    public String checkout(){
        return basePackage + "checkout";
    }
    /**
     * @description: 订单完成页面
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("order-completed")
    public String orderCompleted(){
        return basePackage + "order-completed";
    }
    /**
     * @description: 特殊商品
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("special")
    public String special(){
        return basePackage + "special";
    }
    /**
     * @description: 联系我们
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("contact")
    public String contact(){
        return basePackage + "contact";
    }
    /**
     * @description: 404
     * @author: zyh
     * @date: 2020/11/9
     * @param null
     * @return:
     */
    @RequestMapping("404")
    public String error(){
        return basePackage + "404";
    }
}
