package com.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.auth.service.impl.AuthService;
import com.common.Entity.LoginUser;
import com.common.Entity.SysUser;
import com.common.domain.R;
import com.common.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/9 19:09
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@RestController
public class authController extends BaseController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public R<?> login(LoginUser loginUser){
        R<LoginUser> info = authService.login(loginUser);
        if (info.getData().getSysUser() != null){
            return R.ok("登录成功");
        }
        return R.fail("登录失败");
    }

    @PostMapping("/register")
    public R<?> register(SysUser sysUser){
        return authService.register(sysUser);
    }


    @GetMapping("/isLogin")
    public String test(){
        StpUtil.checkLogin();
        return StpUtil.isLogin()+"";
    }


    @GetMapping("/logout")
    public void logout(){
        authService.logout();
    }


    @GetMapping("/permission")
    public String test1(){
        return "有权利";
    }


}
