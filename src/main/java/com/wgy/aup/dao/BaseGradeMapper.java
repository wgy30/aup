package com.wgy.aup.dao;

import com.wgy.aup.dto.BaseGrade;
import java.util.List;

public interface BaseGradeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseGrade record);

    BaseGrade selectByPrimaryKey(Long id);

    List<BaseGrade> selectAll();

    int updateByPrimaryKey(BaseGrade record);
}