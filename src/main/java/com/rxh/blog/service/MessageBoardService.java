package com.rxh.blog.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.rxh.blog.entity.MessageBoard;

/**
 * 留言板(MessageBoard)表服务接口
 *
 * @author zyh
 * @since 2021-02-10 12:23:11
 */
public interface MessageBoardService extends IService<MessageBoard> {
    Page<MessageBoard> findByPage(Page page, Wrapper wrapper);
    PageInfo findBoards(String curPage, String size);
    boolean deleteLogic(String id);
}