package com.wgy.aup.dto;

import java.util.Date;

public class BaseGrade {
    private Long id;

    private Long gradeCode;

    private Long studentCode;

    private Float gradeValue;

    private Date recordTime;

    private Long courseCode;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(Long gradeCode) {
        this.gradeCode = gradeCode;
    }

    public Long getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(Long studentCode) {
        this.studentCode = studentCode;
    }

    public Float getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(Float gradeValue) {
        this.gradeValue = gradeValue;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Long getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Long courseCode) {
        this.courseCode = courseCode;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}