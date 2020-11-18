package com.rxh.wechat.mapper;

import com.rxh.complat.common.shiro.entity.SysUser;

/**
 * 运营后台用户表(SysUser)表数据库访问层
 *
 * @author zyh
 * @Date 2020-11-04 15:33:26
 */
public interface SysUserMapper {
    SysUser queryByName(String name);
}