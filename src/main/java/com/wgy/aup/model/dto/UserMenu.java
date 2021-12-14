package com.wgy.aup.model.dto;

import java.util.List;

/**
 * @author wgy
 * @version 2021/11/21 13:57:32
 */
public class UserMenu {
    private Integer id;
    private Long userCode;
    private String account;
    private String username;
    private String phone;
    private String email;
    private String roleName;
    private List<BaseMenu> menus;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<BaseMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<BaseMenu> menus) {
        this.menus = menus;
    }
}
