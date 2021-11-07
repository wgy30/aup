package com.wgy.aup.mapper;

import com.wgy.aup.model.dto.BaseGrade;

import java.util.List;

public interface BaseGradeMapper{
    int insert(BaseGrade record);

    BaseGrade selectByPrimaryKey(Integer id);

    List<BaseGrade> selectAll();

    int updateByPrimaryKey(BaseGrade record);

    int deleteByPrimaryKey(Integer id);
}