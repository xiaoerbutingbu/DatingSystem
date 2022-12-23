package com.gateway.service;

import com.common.exception.CaptchaException;
import com.common.web.domain.AjaxResult;

import java.io.IOException;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/13 16:34
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public interface ValidateCodeService {
    /**
     * 生成验证码
     */
    public AjaxResult createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCaptcha(String code, String uuid) throws CaptchaException;
}
