package com.wgy.aup.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * description TODO
 * author wgy
 * version 2021/8/13 00:09:37
 */
@Data
public class AdminVO implements Serializable {
    private Long id;

    private Long adminCode;

    private String name;

    private Integer age;

    private String address;

    private String email;

    private String phone;

    private String number;

    private String imgFile;

    private Boolean status;

    private Boolean isDeleted;
}
