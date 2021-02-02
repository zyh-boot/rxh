package com.rxh.blog.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * (QuickReview)表实体类
 *
 * @author makejava
 * @since 2021-01-26 10:15:11
 */
@SuppressWarnings("serial")
@Data
public class QuickReview extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 784954273160893302L;

    private String id;

    private String review;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}