package com.wgy.aup.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseTeacher {
    private Long id;

    private Long teacherCode;

    private String name;

    private String password;

    private Integer age;

    private String address;

    private String email;

    private String phone;

    private String number;

    private String imgFile;

    private Boolean status;

    private String profession;

    private Boolean isDeleted;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

}