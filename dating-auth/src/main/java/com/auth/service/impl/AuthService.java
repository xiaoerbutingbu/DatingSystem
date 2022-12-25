package com.auth.service.impl;


import com.auth.service.RemoteUserService;
import com.common.Entity.LoginUser;
import com.common.Entity.SysUser;
import com.common.constant.UserConstants;
import com.common.domain.R;
import com.common.exception.ServiceException;
import com.common.utils.BeanUtil;
import com.common.utils.SaTokenUtils;
import com.common.utils.StringUtils;
import com.user.Entity.User;
import com.user.Service.Impl.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/11 15:10
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Component
public class AuthService {

    @Autowired
    private RemoteUserService remoteUserService;

    private final String text = UserConstants.TEXT;

    public void logout(){
        SaTokenUtils.logout();
    }

    public R<LoginUser> login(LoginUser loginUser){

        if(StringUtils.isAnyBlank(loginUser.getPhone(),loginUser.getPassword())){
            throw new ServiceException("手机号/密码必须填写");
        }
        if (loginUser.getPassword().length() < UserConstants.PASSWORD_MIN_LENGTH || loginUser.getPassword().length() > UserConstants.PASSWORD_MAX_LENGTH){
            throw new ServiceException("用户密码不在指定范围");
        }
        if (loginUser.getPhone().length() < UserConstants.USERNAME_MIN_LENGTH || loginUser.getPassword().length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            throw new ServiceException("手机不在指定范围");
        }
        R<LoginUser> userR = remoteUserService.login(loginUser);
        SaTokenUtils.login(userR.getData().getSysUser());
        return userR;
    }


    public R register(SysUser sysUser){
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(sysUser.getPhone(), sysUser.getPassword()))
        {
            throw new ServiceException("手机号码/密码必须填写");
        }
        if (sysUser.getPhone().length() < UserConstants.USERNAME_MIN_LENGTH || sysUser.getPhone().length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            throw new ServiceException("手机号码长度必须在2到20个字符之间");
        }
        if (sysUser.getPassword().length() < UserConstants.PASSWORD_MIN_LENGTH || sysUser.getPassword().length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            throw new ServiceException("密码长度必须在5到20个字符之间");
        }
        R<Boolean> r = remoteUserService.register(sysUser);
        return r;
    }
}
