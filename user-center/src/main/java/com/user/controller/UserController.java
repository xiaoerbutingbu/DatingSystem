package com.user.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.common.Entity.LoginUser;
import com.common.domain.R;
import com.common.exception.ServiceException;
import com.common.utils.SaTokenUtils;
import com.common.web.controller.BaseController;
import com.common.web.domain.AjaxResult;
import com.user.Entity.User;
import com.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/11 16:58
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R<LoginUser> login(@RequestBody LoginUser loginUser){
        User sysUser = userService.login(loginUser);
        if (sysUser!=null){
            loginUser.setSysUser(sysUser);
        }
        return R.ok(loginUser);
    }

    @PostMapping("/register")
    public R<Boolean> register(@RequestBody User user){
        System.out.println("userController register");
        int res = userService.register(user);
        if (res > 0){
            return R.ok(true);
        }
        return R.fail(false);
    }





    @GetMapping("/isLogin")
    @SaCheckPermission("user.isLogin")
    public R<?> isLogin(){
        System.out.println("userController isLogin");
        return R.ok();
    }

    @GetMapping("/alter")
    public AjaxResult alter(){
        System.out.println("userController alter");
        System.out.println(SaTokenUtils.getSaSession());
        return toAjax(1);
    }


}

