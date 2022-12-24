package com.gateway.SaToken;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/24 15:15
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Component
public class StpInterfaceImpl implements StpInterface {


    @Override
    public List<String> getPermissionList(Object o, String s) {
        List<String > res = new ArrayList<>();
        res.add("user.alter");
        return res;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        List<String > res = new ArrayList<>();
        res.add("user");
        return res;
    }
}
