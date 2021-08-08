package com.wgy.aup.dao;

import com.wgy.aup.dto.BaseClass;
import java.util.List;

public interface BaseClassMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseClass record);

    BaseClass selectByPrimaryKey(Long id);

    List<BaseClass> selectAll();

    int updateByPrimaryKey(BaseClass record);
}