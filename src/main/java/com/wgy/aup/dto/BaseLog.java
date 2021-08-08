package com.wgy.aup.dto;

import java.util.Date;

public class BaseLog {
    private Long id;

    private Long logCode;

    private String logContext;

    private String name;

    private Date createTime;

    private Boolean isDeleted;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogCode() {
        return logCode;
    }

    public void setLogCode(Long logCode) {
        this.logCode = logCode;
    }

    public String getLogContext() {
        return logContext;
    }

    public void setLogContext(String logContext) {
        this.logContext = logContext == null ? null : logContext.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}