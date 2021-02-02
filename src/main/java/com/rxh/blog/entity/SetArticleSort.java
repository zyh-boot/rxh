package com.rxh.blog.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * 文章-分类中间表
 (SetArticleSort)表实体类
 *
 * @author zyh
 * @since 2021-02-02 10:06:46
 */
@Data
@SuppressWarnings("serial")
public class SetArticleSort extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -76505810730473227L;

    private String id;
    //文章ID
    private String articleId;
    //分类ID
    private String sortId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }


}