package com.rxh.onlineStore.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.rxh.onlineStore.entity.SysUser;

import java.util.List;

/**
 * 运营后台用户表(SysUser)表服务接口
 *
 * @author zyh
 * @Date 2021-01-06 11:25:54
 */
public interface LineUserService  {
    int insert(SysUser sysUser);
    List<SysUser> findAll(int pageNum,int pageSize);
}