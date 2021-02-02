package com.rxh.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.blog.entity.SetArticleSort;

import java.util.List;

/**
 * 文章-分类中间表
 (SetArticleSort)表数据库访问层
 *
 * @author zyh
 * @since 2021-02-02 10:06:47
 */
public interface SetArticleSortMapper extends BaseMapper<SetArticleSort> {
    //批量插入
    boolean insertBatch(List<SetArticleSort> entities);

    //逻辑删除
    boolean deleteLogic(String id);
}