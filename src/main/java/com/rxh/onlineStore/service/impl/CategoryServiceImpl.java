package com.rxh.onlineStore.service.impl;

import com.rxh.onlineStore.entity.Category;
import com.rxh.onlineStore.mapper.CategoryMapper;
import com.rxh.onlineStore.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类(Category)表服务实现类
 *
 * @author zyh
 * @since 2020-11-10 17:16:25
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Category queryById(Integer id) {
        return this.categoryMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Category> queryAllByLimit(int offset, int limit) {
        return this.categoryMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    @Override
    public Category insert(Category category) {
        this.categoryMapper.insert(category);
        return category;
    }

    /**
     * 修改数据
     *
     * @param category 实例对象
     * @return 实例对象
     */
    @Override
    public Category update(Category category) {
        this.categoryMapper.update(category);
        return this.queryById(category.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.categoryMapper.deleteById(id) > 0;
    }
}