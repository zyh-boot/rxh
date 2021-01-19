package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxh.blog.entity.Comment;
import com.rxh.blog.mapper.CommentMapper;
import com.rxh.blog.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * 文章评论表(Comment)表服务实现类
 *
 * @author zyh
 * @Date 2021-01-19 15:47:21
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}