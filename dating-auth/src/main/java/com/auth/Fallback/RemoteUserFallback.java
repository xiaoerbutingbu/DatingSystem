package com.auth.Fallback;


import com.auth.service.RemoteUserService;
import com.common.Entity.LoginUser;
import com.common.Entity.SysUser;
import com.common.domain.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/11 15:40
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Component
public class RemoteUserFallback implements FallbackFactory<RemoteUserService> {

    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallback.class);

    @Override
    public RemoteUserService create(Throwable throwable) {

        log.error("鉴权服务调用失败：{}",throwable.getMessage());

        return new RemoteUserService() {

            @Override
            public R<LoginUser> login(LoginUser loginUser) {
                return R.fail("用户登录失败："+throwable.getMessage());
            }

            @Override
            public R<Boolean> register(SysUser sysUser) {
                return R.fail("用户注册失败："+throwable.getMessage());
            }

        };
    }
}
