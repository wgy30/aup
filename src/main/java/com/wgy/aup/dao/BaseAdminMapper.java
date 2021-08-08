package com.wgy.aup.dao;

import com.wgy.aup.dto.BaseAdmin;
import java.util.List;

public interface BaseAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseAdmin record);

    BaseAdmin selectByPrimaryKey(Long id);

    List<BaseAdmin> selectAll();

    int updateByPrimaryKey(BaseAdmin record);
}