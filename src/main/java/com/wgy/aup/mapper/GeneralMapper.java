package com.wgy.aup.mapper;

import java.util.List;

/**
 * description 通用Mapper
 * author wgy
 * version 2021/8/8 21:56:05
 *
 * @param <T> 实体类型
 * @param <PK> 主键泛型
 */
public interface GeneralMapper<T,PK> {

    int insert(T record);

    T selectByPrimaryKey(PK key);

    List<T> selectAll();

    int updateByPrimaryKey(T record);

    int deleteByPrimaryKey(PK key);

}
