package com.auth;


import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/9 19:23
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AuthApplication8010 {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication8010.class,args);
        System.out.println("\n启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
