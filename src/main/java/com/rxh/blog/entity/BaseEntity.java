package com.rxh.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 *
 * @Description: 基类
 * @Author Zhang YuHui 
 * @Date 2021/1/18 10:11
 *
 */
@Data
public class BaseEntity {

    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
}
