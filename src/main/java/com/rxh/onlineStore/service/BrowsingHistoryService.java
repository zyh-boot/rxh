package com.rxh.onlineStore.service;

import com.rxh.onlineStore.entity.BrowsingHistory;

import java.util.List;

/**
 * 浏览历史(BrowsingHistory)表服务接口
 *
 * @author zyh
 * @since 2020-11-10 17:16:21
 */
public interface BrowsingHistoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BrowsingHistory queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BrowsingHistory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param browsingHistory 实例对象
     * @return 实例对象
     */
    BrowsingHistory insert(BrowsingHistory browsingHistory);

    /**
     * 修改数据
     *
     * @param browsingHistory 实例对象
     * @return 实例对象
     */
    BrowsingHistory update(BrowsingHistory browsingHistory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}