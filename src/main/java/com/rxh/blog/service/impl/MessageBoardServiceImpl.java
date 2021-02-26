package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rxh.blog.entity.MessageBoard;
import com.rxh.blog.mapper.MessageBoardMapper;
import com.rxh.blog.service.MessageBoardService;
import org.springframework.stereotype.Service;

/**
 * 留言板(MessageBoard)表服务实现类
 *
 * @author zyh
 * @since 2021-02-10 12:23:12
 */
@Service("messageBoardService")
public class MessageBoardServiceImpl extends ServiceImpl<MessageBoardMapper, MessageBoard> implements MessageBoardService {

    /**
     * @Description 带条件的分页查询
     * @author Zhang YuHui
     *
     * @param page 分页 为空时,查询所有
     * @param wrapper 可为空 
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.rxh.blog.entity.Article>
     */
    @Override
    public Page<MessageBoard> findByPage(Page page, Wrapper wrapper) {
        return this.baseMapper.findByPage(page, wrapper);
    }

    @Override
    public PageInfo<MessageBoard> findBoards(String curPage, String size) {
        PageHelper.startPage(Integer.parseInt(curPage),Integer.parseInt(size));
        PageInfo<MessageBoard> pageInfo = new PageInfo<>(this.baseMapper.queryBorad());
        return pageInfo;
    }

    @Override
    public boolean deleteLogic(String id) {
        return this.baseMapper.deleteLogic(id);
    }

}