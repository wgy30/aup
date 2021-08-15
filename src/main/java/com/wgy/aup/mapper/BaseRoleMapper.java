package com.wgy.aup.mapper;

import com.wgy.aup.model.dto.BaseRole;
import java.util.List;

public interface BaseRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseRole record);

    BaseRole selectByPrimaryKey(Long id);

    List<BaseRole> selectAll();

    int updateByPrimaryKey(BaseRole record);
}