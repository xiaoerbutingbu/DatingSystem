package com.user.Service.Impl;


import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.stp.StpUtil;
import com.common.Entity.LoginUser;
import com.user.Entity.User;
import com.user.Mapper.UserMapper;
import com.user.Service.UserService;
import com.user.configure.SaTokenConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/12 12:37
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordService passwordService;

    @Override
    public int register(User user){
        user.setPassword(passwordService.aesEncrypt(user.getPassword()));
        int res = userMapper.insertSysUser(user);
        return res;
    }

    @Override
    public User login(LoginUser loginUser) {
        User user = userMapper.getSysUserByPhone(loginUser.getPhone());
        if (user != null){
            passwordService.validate(user, loginUser.getPassword());
            StpUtil.login(user.getUserId());
            return user;
        }
        return user;
    }

    @Override
    public void logout() {
      //  SaTokenUtils.logout(SaTokenUtils.getSysUser());
        StpUtil.login(StpUtil.getTokenValue());
    }


}
