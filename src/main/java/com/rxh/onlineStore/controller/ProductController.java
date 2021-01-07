package com.rxh.onlineStore.controller;

import com.rxh.onlineStore.entity.Product;
import com.rxh.onlineStore.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表(Product)表控制层
 *
 * @author zyh
 * @since 2020-11-10 17:16:26
 */
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Product selectOne(Integer id) {
        return this.productService.queryById(id);
    }

    @RequestMapping("search")
    public List<Product> search(String name,String category){
//        productService.
        return null;
    }

}