package com.user.Service.Impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.common.Entity.SysUser;
import com.common.constant.CacheConstants;
import com.common.constant.UserConstants;
import com.common.exception.ServiceException;
import com.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/11 15:21
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Component
public class PasswordService {

    @Autowired
    private RedisService redisService;

    private final int maxRetryConut = CacheConstants.PASSWORD_MAX_RETRY_COUNT;

    private final Long lockTime = CacheConstants.PASSWORD_LOCK_TIME;

    private final String text = UserConstants.TEXT;

    public String getCacheKey(String userName){
        return CacheConstants.PWD_ERR_CNT_KEY + userName;
    }

    public final String aesEncrypt(String password){
        return SaSecureUtil.aesEncrypt(password,text);
    }

    public void validate(SysUser user, String password){
        String userName = user.getUserName();
        Integer retryCount = redisService.getCacheObject(getCacheKey(userName));
        if (retryCount == null){
            retryCount = 0;
        }

        if (retryCount >= Integer.valueOf(maxRetryConut).intValue()){
            String errMsg = String.format("密码输入错误%s次，帐户锁定%s分钟", maxRetryConut, lockTime);
            throw new ServiceException(errMsg);
        }
        if (!matches(password,user.getPassword())){
            retryCount++;
            redisService.setCacheObject(getCacheKey(userName),retryCount,lockTime, TimeUnit.MINUTES);
            throw new ServiceException("用户不存在/密码错误");
        }else {
            clearLoginCache(userName);
        }

    }

    public boolean matches(String password,String sysPassword){
        return aesEncrypt(password).equals(sysPassword);
    }


    public void clearLoginCache(String userName){
        if (redisService.hasKey(getCacheKey(userName))){
            redisService.deleteObject(getCacheKey(userName));
        }
    }
}
