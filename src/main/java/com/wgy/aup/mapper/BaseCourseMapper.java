package com.wgy.aup.mapper;

import com.wgy.aup.model.dto.BaseCourse;
import java.util.List;

public interface BaseCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseCourse record);

    BaseCourse selectByPrimaryKey(Long id);

    List<BaseCourse> selectAll();

    int updateByPrimaryKey(BaseCourse record);
}