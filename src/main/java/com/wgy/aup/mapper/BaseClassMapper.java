package com.wgy.aup.mapper;

import com.wgy.aup.model.dto.BaseClass;
import java.util.List;

public interface BaseClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseClass record);

    BaseClass selectByPrimaryKey(Long id);

    List<BaseClass> selectAll();

    int updateByPrimaryKey(BaseClass record);
}