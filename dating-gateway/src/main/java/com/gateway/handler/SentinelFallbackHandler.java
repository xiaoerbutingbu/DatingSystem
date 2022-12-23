package com.gateway.handler;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.common.utils.ServletUtils;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * @Description :
 * @Project : DatingSystem
 * @Time : 2022/12/12 20:25
 * @Author : CYF
 * @Software : IntelliJ IDEA
 */
public class SentinelFallbackHandler implements WebExceptionHandler {

    private Mono<Void> writeResponse(ServerResponse response,ServerWebExchange exchange){
        return ServletUtils.webFluxResponseWriter(exchange.getResponse(),"请求已经到达最大数量");
    }

    private Mono<ServerResponse> handleBlockedRequest(ServerWebExchange exchange,Throwable throwable){
        return GatewayCallbackManager.getBlockHandler().handleRequest(exchange,throwable);
    }
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (exchange.getResponse().isCommitted())
        {
            return Mono.error(ex);
        }
        if (!BlockException.isBlockException(ex))
        {
            return Mono.error(ex);
        }
        return handleBlockedRequest(exchange, ex).flatMap(response -> writeResponse(response, exchange));

    }

}
