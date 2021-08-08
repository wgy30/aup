package com.wgy.aup.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseClass {
    private Long id;

    private Long classCode;

    private String name;

    private Boolean isDeleted;

    private Boolean enableState;

    private Date createTime;

    private Date updateTime;

}