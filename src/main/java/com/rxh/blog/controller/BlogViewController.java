package com.rxh.blog.controller;

import com.rxh.blog.entity.Article;
import com.rxh.blog.service.ArticleService;
import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @Description: 视图映射
 * @Author Zhang YuHui 
 * @Date 2021/1/12 11:47
 *
 */
@Controller
@RequestMapping("blog")
public class BlogViewController {
    @RequestMapping("index")
    public String index() {
        return "pages/blog/index";
    }

    @RequestMapping("header")
    public String header() {
        return "pages/blog/header";
    }

    @RequestMapping("footer")
    public String footer() {
        return "pages/blog/footer";
    }

    @RequestMapping("about")
    public String about() {
        return "pages/blog/about";
    }

    @RequestMapping("list")
    public String list() {
        return "pages/blog/list";
    }

    @RequestMapping("list2")
    public String list2() {
        return "pages/blog/list2";
    }

    @RequestMapping("list3")
    public String list3() {
        return "pages/blog/list3";
    }

    @RequestMapping("article")
    public String article() {
        return "pages/blog/article";
    }

    @RequestMapping("addArticle")
    public ModelAndView addArticle() {
        ModelAndView view = new ModelAndView("pages/blog/add-article");
        Member user = SessionUtils.getUser();

        view.addObject("userName", user.getNickname());
        return view;
    }

    @RequestMapping("jstl")
    public ModelAndView jstl() {
        ModelAndView view = new ModelAndView("pages/blog/jstl");
        Member user = SessionUtils.getUser();

        view.addObject("username", user.getUsername());
        return view;
    }

    @RequestMapping("userInfo")
    public String userInfo() {
        return "pages/blog/user";
    }

    @RequestMapping("articleInfo")
    public ModelAndView articleInfo(String id) {
        ModelAndView view = new ModelAndView("pages/blog/info");
        view.addObject("id",id);
        return view;
    }

    @RequestMapping("daohang")
    public String daohang() {
        return "pages/blog/daohang";
    }

    @Autowired
    ArticleService articleService;

    @RequestMapping("addSuccess")
    public ModelAndView addSuccess(String id) {
        ModelAndView view = new ModelAndView("pages/blog/add-success");
        Article article = articleService.getById(id);
        view.addObject("article", article);
        return view;
    }

    @RequestMapping("commonForm")
    public ModelAndView commonForm() {
        ModelAndView view = new ModelAndView("pages/blog/1111");
        return view;
    }
}