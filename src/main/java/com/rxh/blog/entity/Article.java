package com.rxh.blog.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 博文文章表(Article)表实体类
 *
 * @author zyh
 * @since 2021-02-01 17:07:36
 */
@SuppressWarnings("serial")
@Data
public class Article extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -33574148181311852L;

    private String id;
    //标题
    private String title;
    //摘要
    private String abstractTxt;
    //原创类型 0 原创 1 转载
    private String original;
    //文章内容
    private String content;
    //作者
    private String author;
    //作者ID
    private String authorId;
    //附件保存路径
    private String enclosure;
    //评论量
    private String comments;
    //阅读量
    private String readVolume;
    //收藏量
    private String collection;
    //点赞量
    private String likesNum;
    //展示方式:0 私密 1 公开 2 粉丝可见
    private String showType;
    //置顶状态[ 1 置顶，0 不置顶 默认 ]
    private String topStatus;

    //标签
    @TableField(exist = false)
    private List<Labels> labels;
    //文章分类
    @TableField(exist = false)
    private List<Sorts> category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractTxt() {
        return abstractTxt;
    }

    public void setAbstractTxt(String abstractTxt) {
        this.abstractTxt = abstractTxt;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(String enclosure) {
        this.enclosure = enclosure;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getReadVolume() {
        return readVolume;
    }

    public void setReadVolume(String readVolume) {
        this.readVolume = readVolume;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(String likesNum) {
        this.likesNum = likesNum;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getTopStatus() {
        return topStatus;
    }

    public void setTopStatus(String topStatus) {
        this.topStatus = topStatus;
    }


}