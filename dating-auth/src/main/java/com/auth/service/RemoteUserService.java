package com.auth.service;


import com.auth.Fallback.RemoteUserFallback;
import com.common.Entity.LoginUser;
import com.common.Entity.SysUser;
import com.common.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/11 15:33
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */

@FeignClient(contextId = "remoteUserService",value = "user-center",fallbackFactory = RemoteUserFallback.class)
public interface RemoteUserService {


    @PostMapping("/user/login")
    public R<LoginUser> login(LoginUser loginUser);

    @PostMapping("/user/register")
    public R<Boolean> register(SysUser sysUser);

}
