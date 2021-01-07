package com.rxh.onlineStore.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品分类(Category)实体类
 *
 * @author zyh
 * @Date 2020-11-10 17:17:17
 */
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 326069371133039711L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 分类名
     */
    private String name;
    /**
     * 上级分类ID
     */
    private Integer parentId;


}