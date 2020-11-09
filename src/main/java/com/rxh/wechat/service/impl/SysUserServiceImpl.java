package com.rxh.wechat.service.impl;

import com.rxh.wechat.common.shiro.entity.SysUser;
import com.rxh.wechat.mapper.SysUserMapper;
import com.rxh.wechat.service.SysUserService;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 运营后台用户表(SysUser)表服务实现类
 *
 * @author zyh
 * @since 2020-11-06 11:02:17
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    @Override
    public SysUser queryByName(String name) {
        return this.sysUserDao.queryByName(name);
    }


}