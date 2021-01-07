package com.rxh.onlineStore.controller;

import com.rxh.onlineStore.entity.Category;
import com.rxh.onlineStore.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品分类(Category)表控制层
 *
 * @author zyh
 * @since 2020-11-10 17:16:25
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Category selectOne(Integer id) {
        return this.categoryService.queryById(id);
    }

}