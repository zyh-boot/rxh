package com.rxh.blog.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * 分类表(Sorts)表实体类
 *
 * @author zyh
 * @since 2021-02-01 17:08:25
 */
@SuppressWarnings("serial")
@Data
public class Sorts extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 806856063393882432L;
    //分类ID
    private String sortId;
    //分类名称
    private String sortName;
    //分类别名
    private String sortAlias;
    //分类描述
    private String sortDescription;
    //父分类ID
    private String parentSortId;


    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortAlias() {
        return sortAlias;
    }

    public void setSortAlias(String sortAlias) {
        this.sortAlias = sortAlias;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    public String getParentSortId() {
        return parentSortId;
    }

    public void setParentSortId(String parentSortId) {
        this.parentSortId = parentSortId;
    }


}