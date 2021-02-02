package com.rxh.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @Description: 基类
 * @Author Zhang YuHui 
 * @Date 2021/1/18 10:11
 * 配置类: com/rxh/blog/config/MyMetaObjectHandler.java
 */
@Data
public class BaseEntity {

    //value 指向数据库对应字段 fill指定使用哪一个过滤器
    @TableField(value = "CREATE_TIME" ,fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")  //指定序列化格式,否则传回前端,会变成数组
    private LocalDateTime createTime;


    @TableField(value = "UPDATE_TIME" ,fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;

    @TableField(value = "STATUS",fill = FieldFill.INSERT)
    private int status;
}
