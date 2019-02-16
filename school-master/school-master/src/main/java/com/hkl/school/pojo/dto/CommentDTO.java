package com.hkl.school.pojo.dto;

import java.util.Date;

/**
 * author:zwy
 * Date:2018/10/12
 * Time:14:18
 */
public class CommentDTO {

    private Long cid;   //评论id
    private Long uid;   //用户id
    private String account;     //用户名
    private String content;     //评论内容
    private Date createTime;    //评论时间

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
