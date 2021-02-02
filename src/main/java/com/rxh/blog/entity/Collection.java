package com.rxh.blog.entity;


import java.io.Serializable;

/**
 * (Collection)表实体类
 *
 * @author zyh
 * @since 2021-01-29 12:02:22
 */
@SuppressWarnings("serial")
public class Collection extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -77692068453644055L;
    //主键
    private String id;
    //文章ID
    private String articleId;
    //文章作者ID
    private String articleAuthorId;
    //收藏用户ID
    private String userId;
    //收藏用户名
    private String userName;


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

    public String getArticleAuthorId() {
        return articleAuthorId;
    }

    public void setArticleAuthorId(String articleAuthorId) {
        this.articleAuthorId = articleAuthorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}