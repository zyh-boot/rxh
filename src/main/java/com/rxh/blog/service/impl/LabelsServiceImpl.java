package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxh.blog.entity.Labels;
import com.rxh.blog.mapper.LabelsMapper;
import com.rxh.blog.service.LabelsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章标签表(Labels)表服务实现类
 *
 * @author zyh
 * @since 2021-01-28 17:49:02
 */
@Service("labelsService")
public class LabelsServiceImpl extends ServiceImpl<LabelsMapper, Labels> implements LabelsService {

    @Override
    public List<Labels> findByArticleId(String id) {
        List<Labels> articleId = this.baseMapper.findByArticleId(id);
        return articleId;
    }
}