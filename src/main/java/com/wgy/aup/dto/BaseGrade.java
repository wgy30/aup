package com.wgy.aup.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseGrade {
    private Long id;

    private Long gradeCode;

    private Long studentCode;

    private Float gradeValue;

    private Date recordTime;

    private Long courseCode;

    private Date updateTime;

}