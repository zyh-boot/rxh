package com.rxh.onlineStore.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rxh.onlineStore.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 运营后台用户表(SysUser)表数据库访问层
 *
 * @author zyh
 * @Date 2021-01-06 11:25:54
 */
@Repository
public interface LineUserMapper  {
   List<SysUser> findAll();
   int insert(SysUser sysUser);
}