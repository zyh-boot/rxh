package com.rxh.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rxh.blog.entity.Comment;
import com.rxh.blog.mapper.TreeVOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @Description:
 * @Author Zhang YuHui 
 * @Date 2021/1/22 9:57
 *
 */
@Service
public class TreeVOService {
    @Autowired
    TreeVOMapper treeVOMapper;

    public PageInfo findPage(String size,String page){

        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
        PageInfo<Comment> pageInfo = new PageInfo<>(treeVOMapper.findReplay());
        return pageInfo;
    }

    public Page<Comment> findPlusPage(String size,String page){
        Page<Comment> page1 = new Page<>(Long.valueOf(page),Long.valueOf(size));

        List<Comment> allComment = treeVOMapper.findReplay();
        page1.setRecords(allComment);
//        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
//        PageInfo<Comment> pageInfo = new PageInfo<>(allComment);
        return page1;
    }
}
