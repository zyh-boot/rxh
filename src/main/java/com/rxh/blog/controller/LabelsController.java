package com.rxh.blog.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rxh.blog.entity.Labels;
import com.rxh.blog.service.LabelsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 文章标签表(Labels)表控制层
 *
 * @author zyh
 * @since 2021-01-28 17:49:03
 */
@RestController
@RequestMapping("labels")
public class LabelsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private LabelsService labelsService;

    @RequestMapping("test")
    public Object findByArticleId(String id){
        List<Labels> labels = labelsService.findByArticleId(id);
        return labels;
    }

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

        Page<Labels> page = new Page<>();
        page.setSize(Integer.parseInt(size));
        page.setCurrent(Integer.parseInt(curPage));

        return success(this.labelsService.page(page));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.labelsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param labels 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(Labels labels) {
        return success(this.labelsService.save(labels));
    }

    /**
     * 修改数据
     *
     * @param labels 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(Labels labels) {
        return success(this.labelsService.updateById(labels));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.labelsService.removeByIds(idList));
    }
}