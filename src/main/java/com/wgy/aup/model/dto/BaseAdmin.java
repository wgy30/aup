package com.wgy.aup.model.dto;

import lombok.Data;

@Data
public class BaseAdmin {
    private Long id;

    private Long adminCode;

    private String name;

    private Integer age;

    private String address;

    private String email;

    private String phone;

    private String number;

    private String password;

    private String imgFile;

    private Boolean status;

    private Boolean isDeleted;
}