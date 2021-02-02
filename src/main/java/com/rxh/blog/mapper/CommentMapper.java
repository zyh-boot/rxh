package com.rxh.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.blog.entity.Comment;

import java.util.List;

/**
 * 文章评论表(Comment)表数据库访问层
 *
 * @author zyh
 * @Date 2021-01-19 15:47:21
 */
public interface CommentMapper extends BaseMapper<Comment> {
   List<Comment> queryReplay(String id);
   Comment queryById(String id);
   boolean deleteLogic(String id);
   boolean insertBatch(List<Comment> entities);
}