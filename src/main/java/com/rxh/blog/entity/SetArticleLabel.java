package com.rxh.blog.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * (SetArticleLabel)表实体类
 *
 * @author zyh
 * @since 2021-02-01 17:52:10
 */
@SuppressWarnings("serial")
@Data
public class SetArticleLabel extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 339780534698114985L;

    private String id;

    private String articleId;

    private String labelId;


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

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }


}