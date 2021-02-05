package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxh.blog.entity.Article;
import com.rxh.blog.mapper.ArticleMapper;
import com.rxh.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发布号作者表(Article)表服务实现类
 *
 * @author zyh
 * @Date 2021-01-14 11:18:58
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    public Page selectPage(Page page, Wrapper wrapper) {
        Page page1 = articleMapper.selectPage(page, wrapper);
        return page1;
    }

    public Page selectPage(Page page) {
        Page page1 = articleMapper.selectPage(page, new LambdaQueryWrapper<>());
        return page1;
    }

    @Override
    public boolean setTop(String id) {
        boolean b = articleMapper.setTop(id);
        return b;
    }

    @Override
    public Article getTop(String id) {
        return articleMapper.getTop(id);
    }

    @Override
    public Article queryById(String id) {
        return this.baseMapper.queryById(id);
    }

    /**
     * @Description 带条件的分页查询
     * @author Zhang YuHui
     * @date 2021/2/5
     *
     * @param page 分页 为空时,查询所有
     * @param wrapper 可为空
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.rxh.blog.entity.Article>
     */
    @Override
    public Page<Article> findByPage(Page page, Wrapper wrapper) {
        return this.baseMapper.findByPage(page, wrapper);
    }


}