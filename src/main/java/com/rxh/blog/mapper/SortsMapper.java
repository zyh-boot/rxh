package com.rxh.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.blog.entity.Sorts;

import java.util.List;

/**
 * 分类表(Sorts)表数据库访问层
 *
 * @author zyh
 * @since 2021-02-01 17:08:27
 */
public interface SortsMapper extends BaseMapper<Sorts> {
    //批量插入
    boolean insertBatch(List<Sorts> entities);

    //逻辑删除
    boolean deleteLogic(String id);

    List<Sorts> findByArticleId(String id);
}