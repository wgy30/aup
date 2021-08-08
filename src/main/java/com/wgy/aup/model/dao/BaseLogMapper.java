package com.wgy.aup.model.dao;

import com.wgy.aup.model.dto.BaseLog;
import java.util.List;

public interface BaseLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseLog record);

    BaseLog selectByPrimaryKey(Long id);

    List<BaseLog> selectAll();

    int updateByPrimaryKey(BaseLog record);
}