package com.rxh.onlineStore.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rxh.onlineStore.entity.SysUser;
import com.rxh.onlineStore.mapper.LineUserMapper;
import com.rxh.onlineStore.service.LineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 运营后台用户表(Member)表服务实现类
 *
 * @author zyh
 * @Date 2021-01-06 11:25:54
 */
@Service("lineUserService")
public class LineUserServiceImpl implements LineUserService {

    @Autowired
    LineUserMapper baseMapper;

    @Override
    public int insert(SysUser sysUser) {

        return this.baseMapper.insert(sysUser);
    }

    @Override
    public List<SysUser> findAll(int pageNum, int pageSize) {
        List<SysUser> all = this.baseMapper.findAll();
        return all;
    }
}