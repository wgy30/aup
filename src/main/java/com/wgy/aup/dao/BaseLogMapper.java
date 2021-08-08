package com.wgy.aup.dao;

import com.wgy.aup.dto.BaseLog;
import java.util.List;

public interface BaseLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseLog record);

    BaseLog selectByPrimaryKey(Long id);

    List<BaseLog> selectAll();

    int updateByPrimaryKey(BaseLog record);
}