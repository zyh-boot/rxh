package com.rxh.wechat.common.shiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 后台角色表(SysRole)实体类
 *
 * @author zyh
 * @Date 2020-11-06 10:25:11
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = -76156786472577622L;

    private Integer id;
    /**
     * 角色名
     */
    private String roleName;

    private Date createTime;

    private Date updateTime;
    /**
     * 是否有效  1有效  2无效
     */
    private String deleteStatus;

    /**
     * 权限列表
     */
    private Set<SysPermission> sysPermissions = new HashSet<>();

}