package com.wgy.aup.dao;

import com.wgy.aup.dto.BaseMenu;
import java.util.List;

public interface BaseMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseMenu record);

    BaseMenu selectByPrimaryKey(Long id);

    List<BaseMenu> selectAll();

    int updateByPrimaryKey(BaseMenu record);
}