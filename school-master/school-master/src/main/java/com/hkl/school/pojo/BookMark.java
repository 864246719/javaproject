package com.hkl.school.pojo;

import java.util.Date;

public class BookMark {
    private Long id;

    private Date createTime;

    private Date modifiedTime;

    private Long qustionId;

    private Long userId;

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

    public Long getQustionId() {
        return qustionId;
    }

    public void setQustionId(Long qustionId) {
        this.qustionId = qustionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}