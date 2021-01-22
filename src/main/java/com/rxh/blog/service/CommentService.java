package com.rxh.blog.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.rxh.blog.entity.Comment;

import java.util.List;

/**
 * 文章评论表(Comment)表服务接口
 *
 * @author zyh
 * @Date 2021-01-19 15:47:21
 */
public interface CommentService extends IService<Comment> {
   PageInfo findReplay(String offset, String limit);
   Comment queryById(String id);
}