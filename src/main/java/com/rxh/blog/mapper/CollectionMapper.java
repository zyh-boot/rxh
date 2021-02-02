package com.rxh.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.blog.entity.Collection;

import java.util.List;

/**
 * (Collection)表数据库访问层
 *
 * @author zyh
 * @since 2021-01-29 12:02:24
 */
public interface CollectionMapper extends BaseMapper<Collection> {
    //批量插入
    boolean insertBatch(List<Collection> entities);

    //逻辑删除
    boolean deleteLogic(String id);
}