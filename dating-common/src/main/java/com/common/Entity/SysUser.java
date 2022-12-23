package com.common.Entity;

import com.common.web.domain.BaseEntity;

import java.util.List;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/11 15:31
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public class SysUser extends BaseEntity {

    private long userId;
    private String userName;
    private String phone;
    private String password;
    private String deviceType;
    private List<String> permission;
    private List<String> roles;

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", permission=" + permission +
                ", roles=" + roles +
                '}';
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
