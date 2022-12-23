package com.gateway;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/9 16:24
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GatewayApplication8080 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication8080.class,args);
        System.out.println("\n启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
