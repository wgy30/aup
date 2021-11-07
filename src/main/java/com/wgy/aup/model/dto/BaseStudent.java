package com.wgy.aup.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseStudent {
    private Long id;

    private Long studentCode;

    private String name;

    private String email;

    private String number;

    private Integer age;

    private String address;

    private String phone;

    private String imgFile;

    private Boolean status;

    private Boolean state;

    private Boolean isDeleted;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}