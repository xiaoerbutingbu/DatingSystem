package com.common.SaToken;

import cn.dev33.satoken.stp.StpInterface;
import com.common.utils.SaTokenUtils;
import java.util.List;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/23 14:53
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public class StpInterfaceImpl implements StpInterface {

    @Override
    public List<String> getPermissionList(Object o, String s) {
        List<String> res = SaTokenUtils.getPermissions();
        System.out.println("common:getPermissionList\t\t"+res);
        //res.add("system");
        return res;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        List<String > res = SaTokenUtils.getRoles();
        System.out.println("common:getRoleList\t\t"+res);
        //res.add("user");
        return res;
    }
}
