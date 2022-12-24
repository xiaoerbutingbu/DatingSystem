package com.user.configure;


import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/23 21:01
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Configuration
public class SaTokenConfig implements WebMvcConfigurer {

    @Bean
    public StpLogic getStpLogic(){
        return new StpLogicJwtForSimple();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor())
                .addPathPatterns("/**");
    }
}
