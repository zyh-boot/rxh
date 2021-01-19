package com.rxh.wechat.mapper;

import com.rxh.complat.common.shiro.entity.Member;

/**
 * 运营后台用户表(Member)表数据库访问层
 *
 * @author zyh
 * @Date 2020-11-04 15:33:26
 */
public interface SysUserMapper {
    Member queryByName(String name);
    String addUser(Member member);
}