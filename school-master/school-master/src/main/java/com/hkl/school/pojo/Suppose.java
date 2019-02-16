package com.hkl.school.pojo;

import java.util.Date;

public class Suppose {
    private Long id;

    private Date createTime;

    private Date modifiedTime;

    private Long userId;

    private Long questionId;

    private Byte suppose;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Byte getSuppose() {
        return suppose;
    }

    public void setSuppose(Byte suppose) {
        this.suppose = suppose;
    }
}