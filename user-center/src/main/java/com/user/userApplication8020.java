package com.user;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/11 16:57
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@EnableDiscoveryClient
@SpringBootApplication
public class userApplication8020 {

    public static void main(String[] args) {
        SpringApplication.run(userApplication8020.class,args);
        System.out.println("\n启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
