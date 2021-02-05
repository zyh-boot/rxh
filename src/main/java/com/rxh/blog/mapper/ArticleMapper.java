package com.rxh.blog.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rxh.blog.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 发布号作者表(Article)表数据库访问层
 *
 * @author zyh
 * @Date 2021-01-14 11:18:58
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
    boolean setTop(String id);
    Article getTop(String id);
    Article queryById(String id);
    Page<Article> findByPage(Page<Article> page, @Param(Constants.WRAPPER) Wrapper<Article> ew);
}