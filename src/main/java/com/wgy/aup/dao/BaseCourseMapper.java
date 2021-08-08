package com.wgy.aup.dao;

import com.wgy.aup.dto.BaseCourse;
import java.util.List;

public interface BaseCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseCourse record);

    BaseCourse selectByPrimaryKey(Long id);

    List<BaseCourse> selectAll();

    int updateByPrimaryKey(BaseCourse record);
}