package com.rxh.onlineStore.service.impl;

import com.rxh.onlineStore.entity.BrowsingHistory;
import com.rxh.onlineStore.mapper.BrowsingHistoryMapper;
import com.rxh.onlineStore.service.BrowsingHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 浏览历史(BrowsingHistory)表服务实现类
 *
 * @author zyh
 * @since 2020-11-10 17:16:22
 */
@Service("browsingHistoryService")
public class BrowsingHistoryServiceImpl implements BrowsingHistoryService {
    @Resource
    private BrowsingHistoryMapper browsingHistoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BrowsingHistory queryById(Integer id) {
        return this.browsingHistoryMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BrowsingHistory> queryAllByLimit(int offset, int limit) {
        return this.browsingHistoryMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param browsingHistory 实例对象
     * @return 实例对象
     */
    @Override
    public BrowsingHistory insert(BrowsingHistory browsingHistory) {
        this.browsingHistoryMapper.insert(browsingHistory);
        return browsingHistory;
    }

    /**
     * 修改数据
     *
     * @param browsingHistory 实例对象
     * @return 实例对象
     */
    @Override
    public BrowsingHistory update(BrowsingHistory browsingHistory) {
        this.browsingHistoryMapper.update(browsingHistory);
        return this.queryById(browsingHistory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.browsingHistoryMapper.deleteById(id) > 0;
    }
}