package com.wgy.aup.model.dao;

import com.wgy.aup.model.dto.BaseAdmin;
import java.util.List;

public interface BaseAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseAdmin record);

    BaseAdmin selectByPrimaryKey(Long id);

    List<BaseAdmin> selectAll();

    int updateByPrimaryKey(BaseAdmin record);
}