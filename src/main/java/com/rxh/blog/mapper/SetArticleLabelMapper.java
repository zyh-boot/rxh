package com.rxh.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.blog.entity.SetArticleLabel;

import java.util.List;

/**
 * (SetArticleLabel)表数据库访问层
 *
 * @author zyh
 * @since 2021-02-01 17:52:12
 */
public interface SetArticleLabelMapper extends BaseMapper<SetArticleLabel> {
    //批量插入
    boolean insertBatch(List<SetArticleLabel> entities);

    //逻辑删除
    boolean deleteLogic(String id);
}