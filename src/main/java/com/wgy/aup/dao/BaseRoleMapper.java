package com.wgy.aup.dao;

import com.wgy.aup.dto.BaseRole;
import java.util.List;

public interface BaseRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseRole record);

    BaseRole selectByPrimaryKey(Long id);

    List<BaseRole> selectAll();

    int updateByPrimaryKey(BaseRole record);
}