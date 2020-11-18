package com.rxh.onlineStore.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 浏览历史(BrowsingHistory)实体类
 *
 * @author zyh
 * @Date 2020-11-10 17:17:16
 */
@Data
public class BrowsingHistory implements Serializable {
    private static final long serialVersionUID = -73246931944626556L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 浏览url
     */
    private String url;
    /**
     * 商品一级分类
     */
    private Integer categoryOne;
    /**
     * 商品二级分类
     */
    private Integer categoryTwo;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 停留时间
     */
    private Double stayTime;


}