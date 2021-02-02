package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxh.blog.entity.Collection;
import com.rxh.blog.mapper.CollectionMapper;
import com.rxh.blog.service.CollectionService;
import com.rxh.complat.common.shiro.entity.Member;
import com.rxh.complat.common.util.SessionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Collection)表服务实现类
 *
 * @author zyh
 * @since 2021-01-29 12:02:25
 */
@Service("collectionService")
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {

    /**
     * @Description 判断是否有收藏
     * @author Zhang YuHui
     * @date 2021/1/29
     *
     * @param id 文章Id
     * @return boolean
     */
    @Override
    public boolean isCollection(String id) {
        Member user = SessionUtils.getUser();
        LambdaQueryWrapper<Collection> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Collection::getArticleId,id)
                .eq(Collection::getUserId,user.getId());

        List<Collection> collections = this.baseMapper.selectList(wrapper);

        return collections != null && collections.size()>0 ? true : false;
    }
}