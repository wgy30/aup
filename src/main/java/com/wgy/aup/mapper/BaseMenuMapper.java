package com.wgy.aup.mapper;

import com.wgy.aup.model.dto.BaseMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseMenu record);

    BaseMenu selectByPrimaryKey(Long id);

    List<BaseMenu> selectAll();

    int updateByPrimaryKey(BaseMenu record);

    List<BaseMenu> selectByCodes(Long code);
}