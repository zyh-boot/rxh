package com.rxh.blog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rxh.blog.entity.Sorts;

import java.util.List;

/**
 * 分类表(Sorts)表服务接口
 *
 * @author zyh
 * @since 2021-02-01 17:08:28
 */
public interface SortsService extends IService<Sorts> {
    List<Sorts> findByArticleId(String id);
}