package com.wgy.aup.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description TODO
 * author wgy
 * version 2021/8/13 00:28:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentClassVO implements Serializable {

    /**
     * 学生编码
     */
    private String studentCode;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 工号
     */
    private String number;

    /**
     * 班级编号
     */
    private Long classCode;

    /**
     * 班级名称
     */
    private String name;
}
