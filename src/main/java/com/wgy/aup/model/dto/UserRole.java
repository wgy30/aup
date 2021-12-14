package com.wgy.aup.model.dto;

/**
 * @author wgy
 * @version 2021/11/21 14:36:56
 */
public class UserRole {
    private Integer id;
    private Long userCode;
    private Long roleCode;
    private String roleName;

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public Long getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Long roleCode) {
        this.roleCode = roleCode;
    }
}
