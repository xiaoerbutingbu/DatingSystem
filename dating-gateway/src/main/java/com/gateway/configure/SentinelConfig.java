package com.gateway.configure;

import com.gateway.handler.SentinelFallbackHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/12 20:24
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Configuration
public class SentinelConfig {

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelFallbackHandler sentinelFallbackHandler(){
        return new SentinelFallbackHandler();
    }
}
