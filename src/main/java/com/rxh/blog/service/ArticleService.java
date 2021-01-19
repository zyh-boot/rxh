package com.rxh.blog.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rxh.blog.entity.Article;

/**
 * 发布号作者表(Article)表服务接口
 *
 * @author zyh
 * @Date 2021-01-14 11:18:58
 */
public interface ArticleService extends IService<Article>{
    Page<Article> selectPage(Page page);
}