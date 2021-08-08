package com.wgy.aup.model.dao;

import com.wgy.aup.model.dto.BaseGrade;
import java.util.List;

public interface BaseGradeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseGrade record);

    BaseGrade selectByPrimaryKey(Long id);

    List<BaseGrade> selectAll();

    int updateByPrimaryKey(BaseGrade record);
}