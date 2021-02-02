package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

//    @Override
//    public Page queryAllByLimit(String size, String curPage) {
//        Page<Comment> page = new Page<>();
//        page.setSize(Integer.parseInt(size));
//        page.setCurrent(Integer.parseInt(curPage));
//        Page pages = this.baseMapper.selectPage(page, new LambdaQueryWrapper<Comment>());
//        return pages;
//    }
    @Override
    public PageInfo<Comment> findReplay(String size, String curPage,String id) {
        PageHelper.startPage(Integer.parseInt(curPage),Integer.parseInt(size));
//        List<Comment> comments = this.baseMapper.queryReplay();
        PageInfo<Comment> pageInfo = new PageInfo<>(this.baseMapper.queryReplay(id));
        return pageInfo;
    }


    @Override
    public Comment queryById(String id) {
        return this.baseMapper.queryById(id);
    }

    @Override
    public boolean deleteLogic(String id) {
        return this.baseMapper.deleteLogic(id);
    }

}