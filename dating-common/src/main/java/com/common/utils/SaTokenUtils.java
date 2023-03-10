package com.common.utils;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.common.Entity.SysUser;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


import java.util.List;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/23 14:56
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaTokenUtils {

    public static final String SYS_USER_KEY = "SysUser";

    public static List<String> getRoles(){
        return getSysUser().getRoles();
    }

    public static List<String> getPermissions(){
        return getSysUser().getPermission();
    }

    public static void login(SysUser sysUser){
        SaHolder.getStorage().set(SYS_USER_KEY,sysUser);
        StpUtil.login(sysUser.getUserId(),sysUser.getDeviceType());
        System.out.println("SaTokenUtils:SaHolder\t\t"+SaHolder.getStorage().get(SYS_USER_KEY));
        setSysUser(sysUser);
    }

    public static void setSysUser(SysUser sysUser){
        StpUtil.getTokenSession().set(SYS_USER_KEY,sysUser);
        System.out.println("SaTokenUtils:getTokenSession:\t\t"+StpUtil.getTokenSession().get(SYS_USER_KEY));
    }
    public static void deleteSysUser(SysUser sysUser){
        StpUtil.getTokenSession().delete(SYS_USER_KEY);
    }
    public static SysUser getSysUser(){
        SysUser sysUser = (SysUser)SaHolder.getStorage().get(SYS_USER_KEY);
        System.out.println("SaTokenUtils:getSysUser:SaHolder.getStorage\t\t"+SaHolder.getStorage().get(SYS_USER_KEY));
        if(sysUser != null){
            return sysUser;
        }
        sysUser = (SysUser)StpUtil.getTokenSession().get(SYS_USER_KEY);
        SaHolder.getStorage().set(SYS_USER_KEY,sysUser);
        //System.out.println("getTokenSession,get()\n"+sysUser);
        return sysUser;
    }

    public static void logout(SysUser sysUser){
        SaHolder.getStorage().delete(SYS_USER_KEY);
        deleteSysUser(sysUser);
        StpUtil.logout(sysUser.getUserId());
    }

    public static SaSession getSaSession(){
        return StpUtil.getSession();
    }

    public static void logout(){
        logout(getSysUser());
    }
}
