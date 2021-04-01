package com.saturn.gateway.config;

import com.saturn.gateway.utils.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author lbh
 * @Date 2021/3/30
 * @Description:全局过滤器，注册、登录直接放行，其他请求有token才放行
 */
@Configuration
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    //令牌头信息
    private static final String AUTHORIZE_TOKEN = "token";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取request、response
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //获取请求要访问的路径
        String path = request.getURI().getPath();

        //登录、请求直接放行
        if(path.startsWith("/user/login") || path.startsWith("/user/register")){
            return chain.filter(exchange);
        }

        //获取头文件中的token
        String token = request.getHeaders().getFirst(AUTHORIZE_TOKEN);

        //若token不存在
        if(StringUtils.isEmpty(token)){
            response.setStatusCode(HttpStatus.METHOD_NOT_ALLOWED);
            return response.setComplete();
        }

        //令牌头存在，校对token
        try {
            JwtUtil.verify(token);
        }catch (Exception e){
            //抛出异常说明token验证失败，拦截请求
            e.printStackTrace();
            response.setStatusCode(HttpStatus.MULTI_STATUS);
            return response.setComplete();
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
