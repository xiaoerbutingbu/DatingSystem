package com.common.Entity;

import com.common.web.domain.BaseEntity;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/11 14:53
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public class LoginUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String phone;
    private String password;
    private Boolean rememberMe;
    private SysUser sysUser;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                ", sysUser=" + sysUser +
                '}';
    }
}
