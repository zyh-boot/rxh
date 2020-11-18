package com.rxh.onlineStore.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品表(Product)实体类
 *
 * @author zyh
 * @Date 2020-11-10 17:17:17
 */
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = 640057015307020224L;
    /**
     * 商品ID
     */
    private Integer id;
    /**
     * 商品名
     */
    private String name;
    /**
     * 价格
     */
    private Double price;
    /**
     * 打折
     */
    private Double discount;
    /**
     * 分类
     */
    private Integer categoryId;


}