package com.rxh.blog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rxh.blog.entity.Collection;

/**
 * (Collection)表服务接口
 *
 * @author zyh
 * @since 2021-01-29 12:02:25
 */
public interface CollectionService extends IService<Collection> {
    boolean isCollection(String id);
}