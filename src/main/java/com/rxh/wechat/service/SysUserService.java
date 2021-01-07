package com.rxh.wechat.service;


import com.rxh.complat.common.shiro.entity.SysUser;

/**
 * 运营后台用户表(SysUser)表服务接口
 *
 * @author zyh
 * @since 2020-11-06 11:02:16
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryByName(String name);
    String addUser(SysUser sysUser);



}