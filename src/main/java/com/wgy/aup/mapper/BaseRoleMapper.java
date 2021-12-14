package com.wgy.aup.mapper;

import com.wgy.aup.model.dto.BaseRole;
import com.wgy.aup.model.dto.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BaseRole record);

    BaseRole selectByPrimaryKey(Long id);

    List<BaseRole> selectAll();

    int updateByPrimaryKey(BaseRole record);

    /**
     * 根据用户编码查询角色
     * @param userCode
     * @return
     */
     UserRole selectByCodes(Long userCode);
}