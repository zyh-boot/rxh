package com.rxh.blog.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 留言板(MessageBoard)表实体类
 *
 * @author zyh
 * @since 2021-02-10 12:23:05
 */
@Data
@SuppressWarnings("serial")
public class MessageBoard extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -22123894496422358L;
    //留言id
    private String id;
    //留言人userId
    private String userId;
    //留言人昵称
    private String userName;
    //根留言id
    private String parentCommentId;
    //根留言的用户id
    private String parentCommentUserId;
    //被回复的留言id
    private String replyCommentId;
    //被回复的留言用户id
    private String replyCommentUserId;
    //被回复的用户名
    private String replyCommentUserName;
    //留言等级[ 1 一级评论 默认 ，2 二级评论]
    private Integer commentLevel;
    //留言的内容
    private String content;
    //二级评论
    private List<MessageBoard> messageBoards;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getParentCommentUserId() {
        return parentCommentUserId;
    }

    public void setParentCommentUserId(String parentCommentUserId) {
        this.parentCommentUserId = parentCommentUserId;
    }

    public String getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(String replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public String getReplyCommentUserId() {
        return replyCommentUserId;
    }

    public void setReplyCommentUserId(String replyCommentUserId) {
        this.replyCommentUserId = replyCommentUserId;
    }

    public String getReplyCommentUserName() {
        return replyCommentUserName;
    }

    public void setReplyCommentUserName(String replyCommentUserName) {
        this.replyCommentUserName = replyCommentUserName;
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}