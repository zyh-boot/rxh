package com.rxh.onlineStore.service.impl;

import com.rxh.onlineStore.entity.Product;
import com.rxh.onlineStore.mapper.ProductMapper;
import com.rxh.onlineStore.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表(Product)表服务实现类
 *
 * @author zyh
 * @since 2020-11-10 17:16:25
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Integer id) {
        return this.productMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Product> queryAllByLimit(int offset, int limit) {
        return this.productMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product insert(Product product) {
        this.productMapper.insert(product);
        return product;
    }

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product update(Product product) {
        this.productMapper.update(product);
        return this.queryById(product.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productMapper.deleteById(id) > 0;
    }
}