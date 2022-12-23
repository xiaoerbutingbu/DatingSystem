package com.gateway.configure.properties;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/13 16:31
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Configuration
@RefreshScope
public class CaptchaProperties {
    /**
     * 验证码开关
     */
    private Boolean enabled;

    /**
     * 验证码类型（math 数组计算 char 字符）
     */
    private String type;

    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
