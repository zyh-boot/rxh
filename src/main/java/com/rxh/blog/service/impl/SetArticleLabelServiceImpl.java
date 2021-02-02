package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxh.blog.entity.SetArticleLabel;
import com.rxh.blog.mapper.SetArticleLabelMapper;
import com.rxh.blog.service.SetArticleLabelService;
import org.springframework.stereotype.Service;

/**
 * (SetArticleLabel)表服务实现类
 *
 * @author zyh
 * @since 2021-02-01 17:52:13
 */
@Service("setArticleLabelService")
public class SetArticleLabelServiceImpl extends ServiceImpl<SetArticleLabelMapper, SetArticleLabel> implements SetArticleLabelService {

}