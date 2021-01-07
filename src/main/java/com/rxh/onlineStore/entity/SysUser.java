package com.rxh.onlineStore.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 运营后台用户表(SysUser)表实体类
 *
 * @author zyh
 * @Date 2021-01-06 14:52:55
 */
@SuppressWarnings("serial")
public class SysUser extends Model<SysUser> implements Serializable {
    private static final long serialVersionUID = 744925824265241527L;

    private String id;
    //用户名
    private String username;
    //密码
    private String password;
    //昵称
    private String nickname;
    //角色ID
    private Integer roleId;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //是否有效  1有效  2无效
    private String deleteStatus;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

//    /**
//     * 获取主键值
//     *
//     * @return 主键值
//     */
//    @Override
//    protected Serializable pkVal() {
//        return this.id;
//    }
}