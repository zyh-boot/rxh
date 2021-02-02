package com.rxh.blog.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rxh.blog.entity.Sorts;
import com.rxh.blog.service.SortsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 分类表(Sorts)表控制层
 *
 * @author zyh
 * @since 2021-02-01 17:08:29
 */
@RestController
@RequestMapping("sorts")
public class SortsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SortsService sortsService;

    /**
     * 分页查询所有数据
     *
     * @param size 分页数量
     * @param curPage 当前页码
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(String size, String curPage) {
        size = StringUtils.isNotBlank(size) ? size : "10";
        curPage = StringUtils.isNotBlank(curPage) ? curPage : "1";
        Page<Sorts> page = new Page<>();
        page.setSize(Integer.parseInt(size));
        page.setCurrent(Integer.parseInt(curPage));

        return success(this.sortsService.page(page));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sortsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sorts 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(Sorts sorts) {
        return success(this.sortsService.save(sorts));
    }

    /**
     * 修改数据
     *
     * @param sorts 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(Sorts sorts) {
        return success(this.sortsService.updateById(sorts));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sortsService.removeByIds(idList));
    }
}