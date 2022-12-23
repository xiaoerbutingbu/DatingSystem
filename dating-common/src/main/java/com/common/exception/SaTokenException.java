package com.common.exception;

import cn.dev33.satoken.exception.*;
import com.common.domain.R;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/13 15:01
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@RestControllerAdvice
@Order(1)
public class SaTokenException   {

    @ExceptionHandler(NotRoleException.class)
    public R<?> NotRoleException(NotRoleException e){
        return R.fail(0,"你没有角色:"+e.getRole()+"哟，亲");
    }

    @ExceptionHandler(NotPermissionException.class)
    public R<?> NotPermissionException(NotPermissionException e){
        return R.fail(0,"你没有权利:"+e.getPermission()+"哟，亲");
    }

    @ExceptionHandler(NotSafeException.class)
    public R<?> NotSafeException(NotSafeException e){
        return R.fail(0,"你的账号没有通过二级认证哟，亲");
    }

    @ExceptionHandler(ServiceException.class)
    public R<?> ServiceException(ServiceException e){
       return R.fail(0,e.getMessage());
    }
}
