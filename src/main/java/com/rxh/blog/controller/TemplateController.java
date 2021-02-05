package com.rxh.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.rxh.blog.entity.Article;
import com.rxh.blog.entity.Comment;
import com.rxh.blog.entity.SetArticleSort;
import com.rxh.blog.entity.Sorts;
import com.rxh.blog.service.ArticleService;
import com.rxh.blog.service.CommentService;
import com.rxh.blog.service.SetArticleSortService;
import com.rxh.blog.service.SortsService;
import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description html模板映射  将可复用的html封装为组件调用
 * @author Zhang YuHui
 * @date 2021/1/27
 *
 */
@Controller
@RequestMapping("blog")
public class TemplateController {

    @Autowired
    CommentService commentService;
    @Autowired
    ArticleService articleService;
    @Autowired
    SortsService sortsService;
    @Autowired
    SetArticleSortService articleSortService;


    /**
     * @Description 评论内容加分页
     * @author Zhang YuHui
     * @date 2021/1/27
     *
     * @param id 文章ID
     * @param size
     * @param curPage
     * @param model
     * @return java.lang.String
     */
    @RequestMapping("replay")
    public String replay(String id, String size, String curPage, Model model) {
        PageInfo replay = commentService.findReplay(size, curPage, id);
        model.addAttribute("contents", replay.getList());
        model.addAttribute("total", replay.getTotal());
        model.addAttribute("curpage", curPage);
        model.addAttribute("size", size);
        return "pages/blog/tmplate::comment_replay";
    }

    /**
     * @Description 评论框内容
     * @author Zhang YuHui
     * @date 2021/1/27
     *
     * @param reply
     * @param comment 当前这条评论详情
     * @param model
     * @return java.lang.String
     */
    @RequestMapping("replayTmp")
    public String replayTmp(String reply, String comment, Model model) {
        model.addAttribute("reply", reply);
        Comment object = new Comment();
        if (StringUtils.isNotBlank(comment)) {
            object = JSONObject.parseObject(comment, Comment.class);
        }
        model.addAttribute("comment", object);
        return "pages/blog/tmplate::comment-form";
    }

    @RequestMapping("article-list")
    public String blogList(String size, String curPage, Model model) {
        Page<Article> page = new Page<>();
        page.setSize(Integer.parseInt(size));
        page.setCurrent(Integer.parseInt(curPage));
        Page<Article> articlePage = articleService.selectPage(page, new LambdaQueryWrapper());
        model.addAttribute("articles", articlePage.getRecords());
        model.addAttribute("size", articlePage.getSize());
        model.addAttribute("total", articlePage.getTotal());
        model.addAttribute("curpage", curPage);

        Member user = SessionUtils.getUser();
        Article top = articleService.getTop(user.getId());
        model.addAttribute("topArticle", top);
        return "pages/blog/tmplate::blog_list";
    }

    @RequestMapping("categories")
    public String categories(String isFirst, String size, String curPage, Model model) {
        size = StringUtils.isNotBlank(size) ? size : "10";
        curPage = StringUtils.isNotBlank(curPage) ? curPage : "1";
        Page<Sorts> page = new Page<>();
        page.setSize(Integer.parseInt(size));
        page.setCurrent(Integer.parseInt(curPage));
        Page<Sorts> page1 = this.sortsService.page(page);
        model.addAttribute("categories", page1.getRecords());
        model.addAttribute("flag", isFirst);
        return "pages/blog/tmplate::categories";
    }

    @RequestMapping("categoryArticles")
    public String categoryArticles(String isFirst, String category, String size, String curPage, Model model) {

        size = StringUtils.isNotBlank(size) ? size : "10";
        curPage = StringUtils.isNotBlank(curPage) ? curPage : "1";

        LambdaQueryWrapper<SetArticleSort> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SetArticleSort::getSortId, category);
        List<SetArticleSort> records = articleSortService.list(wrapper);
        if(records == null || records.size() == 0){
            model.addAttribute("articles", "");
            model.addAttribute("flag", isFirst);
            return "pages/blog/tmplate::categoryArticles";
        }
        ArrayList<String> ids = new ArrayList<>();

        for (SetArticleSort record : records) {
            ids.add(record.getArticleId());
        }

        Page<Article> page = new Page<>();
        page.setSize(Integer.parseInt(size));
        page.setCurrent(Integer.parseInt(curPage));

        LambdaQueryWrapper<Article> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.in(Article::getId, ids);
        Page<Article> articlePage = this.articleService.findByPage(page,wrapper1);

        model.addAttribute("articles", articlePage.getRecords());
        model.addAttribute("flag", isFirst);

        return "pages/blog/tmplate::categoryArticles";
    }
}
