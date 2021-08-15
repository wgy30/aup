package com.wgy.aup.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description StudentVO：
 * author wgy
 * version 2021/8/8 23:53:19
 */
@Data
public class StudentVO implements Serializable {

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
