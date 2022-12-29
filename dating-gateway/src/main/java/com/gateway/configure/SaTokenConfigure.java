package com.gateway.configure;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import com.common.utils.SaTokenUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/9 16:37
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Configuration
public class SaTokenConfigure {

    @Bean
    public SaReactorFilter getSaReactorFilter(){
        return new SaReactorFilter()
                .addInclude("/**")
                .addExclude("/favicon.ico")
                .setAuth(obj->{
                    //登录校验
                    SaRouter.match("/auth/**").notMatch("/auth/login").notMatch("/auth/register").notMatch("/auth/logout").check(r -> StpUtil.checkLogin());
                    //SaRouter.match("/**",r-> StpUtil.checkLogin());
                    //SaRouter.match("/auth/**","/auth/login",r-> StpUtil.checkLogin());
                    SaRouter.match("/user/**",r -> StpUtil.checkRoleOr("user","system"));
                    SaRouter.match("/goods/**",r-> StpUtil.checkRoleOr("admin","system"));
                })
                .setBeforeAuth(obj->{
                    SaHolder.getResponse()
                            .setHeader("Access-Control-Allow-Origin", "*")
                            // 允许所有请求方式
                            .setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE")
                            // 有效时间
                            .setHeader("Access-Control-Max-Age", "3600")
                            // 允许的header参数
                            .setHeader("Access-Control-Allow-Headers", "*");
                })
                ;
    }


}
