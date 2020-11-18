package com.rxh.onlineStore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.onlineStore.entity.BrowsingHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 浏览历史(BrowsingHistory)表数据库访问层
 *
 * @author zyh
 * @since 2020-11-10 17:16:21
 */
public interface BrowsingHistoryMapper extends BaseMapper<BrowsingHistoryMapper> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BrowsingHistory queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BrowsingHistory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param browsingHistory 实例对象
     * @return 对象列表
     */
    List<BrowsingHistory> queryAll(BrowsingHistory browsingHistory);

    /**
     * 新增数据
     *
     * @param browsingHistory 实例对象
     * @return 影响行数
     */
    int insert(BrowsingHistory browsingHistory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BrowsingHistory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BrowsingHistory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BrowsingHistory> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<BrowsingHistory> entities);

    /**
     * 修改数据
     *
     * @param browsingHistory 实例对象
     * @return 影响行数
     */
    int update(BrowsingHistory browsingHistory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}