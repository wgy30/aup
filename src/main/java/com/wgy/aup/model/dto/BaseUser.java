package com.wgy.aup.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author wgy
 * @version 2021/11/20 21:42:54
 */
@Data
public class BaseUser {
    private Integer id;
    private Long code;
    /**
     *  姓名
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机
     */
    private String phone;
    /**
     * 头像Url
     */
    private String imgFile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 用户类型：0：学生 1：教师 2：管理员
     */
    private Boolean type;
    /**
     * 住址
     */
    private String address;
    /**
     * 是否删除 0：未删 1：已删除
     */
    private Boolean isDeleted;
    private Date createTime;
    private Date updateTime;
}
