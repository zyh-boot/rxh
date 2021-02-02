package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxh.blog.entity.SetArticleSort;
import com.rxh.blog.mapper.SetArticleSortMapper;
import com.rxh.blog.service.SetArticleSortService;
import org.springframework.stereotype.Service;

/**
 * 文章-分类中间表
 (SetArticleSort)表服务实现类
 *
 * @author zyh
 * @since 2021-02-02 10:06:49
 */
@Service("setArticleSortService")
public class SetArticleSortServiceImpl extends ServiceImpl<SetArticleSortMapper, SetArticleSort> implements SetArticleSortService {

}