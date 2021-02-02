package com.rxh.blog.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxh.blog.entity.QuickReview;
import com.rxh.blog.mapper.QuickReviewMapper;
import com.rxh.blog.service.QuickReviewService;
import org.springframework.stereotype.Service;

/**
 * (QuickReview)表服务实现类
 *
 * @author makejava
 * @since 2021-01-26 10:14:47
 */
@Service("quickReviewService")
public class QuickReviewServiceImpl extends ServiceImpl<QuickReviewMapper, QuickReview> implements QuickReviewService {

}