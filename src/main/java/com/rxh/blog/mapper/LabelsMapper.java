package com.rxh.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.blog.entity.Labels;

import java.util.List;

/**
 * 文章标签表(Labels)表数据库访问层
 *
 * @author zyh
 * @since 2021-01-28 17:49:01
 */
public interface LabelsMapper extends BaseMapper<Labels> {
    //批量插入
    boolean insertBatch(List<Labels> entities);

    //逻辑删除
    boolean deleteLogic(String id);
    List<Labels> queryById(String id);
    List<Labels> findByArticleId(String id);
}