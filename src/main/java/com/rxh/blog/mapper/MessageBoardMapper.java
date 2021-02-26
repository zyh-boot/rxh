package com.rxh.blog.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rxh.blog.entity.MessageBoard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 留言板(MessageBoard)表数据库访问层
 *
 * @author zyh
 * @since 2021-02-10 12:23:09
 */
public interface MessageBoardMapper extends BaseMapper<MessageBoard> {
    //批量插入
    boolean insertBatch(List<MessageBoard> entities);

    //逻辑删除
    boolean deleteLogic(String id);

    //查询
    List<MessageBoard> queryBorad();
    //根据条件分页查询
    Page<MessageBoard> findByPage(Page<MessageBoard> page, @Param(Constants.WRAPPER) Wrapper<MessageBoard> wrapper);
}