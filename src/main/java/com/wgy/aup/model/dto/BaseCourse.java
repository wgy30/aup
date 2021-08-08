package com.wgy.aup.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseCourse {
    private Long id;

    private Long courseCode;

    private String name;

    private Date startTime;

    private Date endTime;

    private Byte state;

    private Boolean isDeleted;

    private Long teacherCode;

}