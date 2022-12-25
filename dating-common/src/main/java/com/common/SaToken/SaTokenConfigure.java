package com.common.SaToken;



import cn.dev33.satoken.interceptor.SaInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/23 21:01
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public class SaTokenConfigure implements WebMvcConfigurer {

//    @Bean
//    public StpLogic getStpLogicJwt() {
//        return new StpLogicJwtForSimple();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }
}
