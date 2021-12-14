package com.wgy.aup.mapper;

import com.wgy.aup.model.dto.BaseUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wgy
 * @version 2021/11/20 21:40:57
 */
@Mapper
public interface BaseUserMapper {

    /**
     * 新增用户
     */
    void insert(BaseUser user);

    /**
     * 删除用户 形式删除
     */
    void delete(@Param("id") Integer id);

    BaseUser select(@Param("account") String account);

    void realDelete(@Param("id")Integer id);

    /**
     * 根据编码查询用户信息
     * @param userCode
     * @return
     */
    BaseUser selectByCode(Long userCode);
}


