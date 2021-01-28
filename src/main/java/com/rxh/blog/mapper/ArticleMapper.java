package com.rxh.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.blog.entity.Article;
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
}