package com.rxh.complat.common.shiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 运营后台用户表(Member)实体类
 *
 * 该类为shiro校验所用 需要操作此表 建议新建一个实体类
 * @author zyh
 * @Date 2020-11-06 10:25:11
 */
@Data
public class Member implements Serializable {
    private static final long serialVersionUID = 378401617321056684L;

    private String id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 是否有效  1有效  2无效
     */
    private String deleteStatus;

    /**
     * 角色列表
     */
    private Set<SysRole> sysRoles;

}