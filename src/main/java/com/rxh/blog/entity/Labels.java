package com.rxh.blog.entity;


import java.io.Serializable;

/**
 * 文章标签表(Labels)表实体类
 *
 * @author zyh
 * @since 2021-01-28 17:48:59
 */
@SuppressWarnings("serial")
public class Labels extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 928420596739211886L;
    //标签ID
    private String labelId;
    //标签名称
    private String labelName;
    //标签别名
    private String labelAlias;
    //标签描述
    private String labelDescription;



    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelAlias() {
        return labelAlias;
    }

    public void setLabelAlias(String labelAlias) {
        this.labelAlias = labelAlias;
    }

    public String getLabelDescription() {
        return labelDescription;
    }

    public void setLabelDescription(String labelDescription) {
        this.labelDescription = labelDescription;
    }




}