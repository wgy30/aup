package com.wgy.aup.mapper;

import com.wgy.aup.model.dto.BaseTeacher;
import java.util.List;

public interface BaseTeacherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseTeacher record);

    BaseTeacher selectByPrimaryKey(Long id);

    List<BaseTeacher> selectAll();

    int updateByPrimaryKey(BaseTeacher record);
}