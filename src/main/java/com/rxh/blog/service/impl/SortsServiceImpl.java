package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxh.blog.entity.Sorts;
import com.rxh.blog.mapper.SortsMapper;
import com.rxh.blog.service.SortsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类表(Sorts)表服务实现类
 *
 * @author zyh
 * @since 2021-02-01 17:08:28
 */
@Service("sortsService")
public class SortsServiceImpl extends ServiceImpl<SortsMapper, Sorts> implements SortsService {

    @Override
    public List<Sorts> findByArticleId(String id) {
        List<Sorts> byArticleId = this.baseMapper.findByArticleId(id);
        return byArticleId;
    }
}