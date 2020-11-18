package com.rxh.onlineStore.controller;

import com.rxh.onlineStore.entity.BrowsingHistory;
import com.rxh.onlineStore.service.BrowsingHistoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 浏览历史(BrowsingHistory)表控制层
 *
 * @author zyh
 * @since 2020-11-10 17:16:23
 */
@RestController
@RequestMapping("browsingHistory")
public class BrowsingHistoryController {
    /**
     * 服务对象
     */
    @Resource
    private BrowsingHistoryService browsingHistoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BrowsingHistory selectOne(Integer id) {
        return this.browsingHistoryService.queryById(id);
    }

}