package com.wgy.aup.dao;

import com.wgy.aup.dto.BaseStudent;
import java.util.List;

public interface BaseStudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseStudent record);

    BaseStudent selectByPrimaryKey(Long id);

    List<BaseStudent> selectAll();

    int updateByPrimaryKey(BaseStudent record);
}