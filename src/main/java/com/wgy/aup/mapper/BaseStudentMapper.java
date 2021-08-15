package com.wgy.aup.mapper;

import com.wgy.aup.model.dto.BaseStudent;
import java.util.List;

public interface BaseStudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseStudent record);

    BaseStudent selectByPrimaryKey(Long id);

    List<BaseStudent> selectAll();

    int updateByPrimaryKey(BaseStudent record);
}