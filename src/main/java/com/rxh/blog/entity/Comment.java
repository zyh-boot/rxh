package com.rxh.blog.entity;


import java.io.Serializable;
import java.util.List;

/**
 * 文章评论表(Comment)表实体类
 *
 * @author zyh
 * @Date 2021-01-22 11:29:43
 */
@SuppressWarnings("serial")
public class Comment extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -19574891095288864L;
    //评论id
    private String id;
    //评论人userId
    private String userId;
    //评论人名称
    private String userName;
    //评论的文章id
    private String articleId;
    //评论的文章标题
    private String articleTitle;
    //父评论id
    private String parentCommentId;
    //父评论的用户id
    private String parentCommentUserId;
    //被回复的评论id
    private String replyCommentId;
    //被回复的评论用户id
    private String replyCommentUserId;
    //被回复的用户名
    private String replyCommentUserName;
    //评论等级[ 1 一级评论 默认 ，2 二级评论]
    private Integer commentLevel;
    //评论的内容
    private String content;
//    //状态 (1 有效，0 逻辑删除)
//    private Integer status;
    //点赞数
    private Integer praiseNum;
    //置顶状态[ 1 置顶，0 不置顶 默认 ]
    private Integer topStatus;
//    //创建时间
//    private Date createTime;
//    //更新时间
//    private Date updateTime;
    //二级评论
    private List<Comment> replyComments;

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

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

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
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

//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getTopStatus() {
        return topStatus;
    }

    public void setTopStatus(Integer topStatus) {
        this.topStatus = topStatus;
    }

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getupdateTime() {
//        return updateTime;
//    }
//
//    public void setupdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
//    @Override
//    protected Serializable pkVal() {
//        return this.id;
//    }
}