package com.rxh.complat.common.shiro.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 后台权限表(SysPermission)实体类
 *
 * @author zyh
 * @Date 2020-11-06 10:25:11
 */
@Data
public class SysPermission implements Serializable {
    private static final long serialVersionUID = -79034680514436121L;
    /**
     * 自定id,主要供前端展示权限列表分类排序使用.
     */
    private Integer id;
    /**
     * 归属菜单,前端判断并展示菜单使用,
     */
    private String menuCode;
    /**
     * 菜单的中文释义
     */
    private String menuName;
    /**
     * 权限的代码/通配符,对应代码中@RequiresPermissions 的value
     */
    private String permissionCode;
    /**
     * 本权限的中文释义
     */
    private String permissionName;
    /**
     * 是否本菜单必选权限, 1.必选 2非必选 通常是"列表"权限是必选
     */
    private Object requiredPermission;


}