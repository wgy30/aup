package com.wgy.aup.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseLog {
    private Long id;

    private Long logCode;

    private String logContext;

    private String name;

    private Date createTime;

    private Boolean isDeleted;

    private Date updateTime;

}