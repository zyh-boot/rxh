package com.rxh.blog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rxh.blog.entity.Labels;

import java.util.List;

/**
 * 文章标签表(Labels)表服务接口
 *
 * @author zyh
 * @since 2021-01-28 17:49:02
 */
public interface LabelsService extends IService<Labels> {
    List<Labels> findByArticleId(String id);
}