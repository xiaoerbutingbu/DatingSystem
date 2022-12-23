package com.common.exception;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/13 16:35
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public class CaptchaException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public CaptchaException(String msg)
    {
        super(msg);
    }
}
