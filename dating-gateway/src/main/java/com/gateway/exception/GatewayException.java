package com.gateway.exception;

import cn.dev33.satoken.exception.*;
import com.common.utils.ServletUtils;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import org.springframework.http.server.reactive.ServerHttpResponse;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/10 11:35
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
@Configuration
@Order(-1)
public class GatewayException implements ErrorWebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse response = exchange.getResponse();
        if (response.isCommitted()){
            Mono.error(ex);
        }
        String msg;
        if (ex instanceof NotLoginException){
            msg = ex.getMessage();
        }
        else if (ex instanceof NotRoleException){
            msg = "没有角色:"+ex.getMessage();
        }
        else if (ex instanceof NotPermissionException){
            msg = "没有权限:"+ex.getMessage();
        }else if (ex instanceof SaTokenException){
            msg = "gateway 未能读取到有效Token";
        }
        else if (ex instanceof NotFoundException){
            msg = "gateway 服务未找到";
        }
        else if(ex instanceof NotSafeException){
            msg = "二级认证失败";
        }
        else if (ex instanceof DisableLoginException){
            msg = "账号已经被封禁";

        }
        else {
            msg = "gateway 内部服务器错误";
        }
        return ServletUtils.webFluxResponseWriter(response,msg);
    }
}

