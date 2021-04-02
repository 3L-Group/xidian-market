package com.saturn.gateway.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

/**
 * Token工具类
 *
 * @Author lbh
 * @Date 2021/3/21
 */

@Component
public class JwtUtil {

    private static final String SIGNATURE = "!Q@W#E$R%T^Y&U*I(O)P";

    private static final String USER_ID = "userId";

    /**
     * 获取token令牌
     * @param map
     * @return
     */
    public static String getToken(Map<String,String> map){

        String token="";

        //获取当前时间
        Calendar instance = Calendar.getInstance();
        //设置7天后过期
        instance.add(Calendar.DATE,7);

        //创建Builder
        JWTCreator.Builder builder = JWT.create();

        //lambda表达式遍历map数据作为Payload字段
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });

        token=builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SIGNATURE));

        return token;
    }

    /**
     * 验签token
     * 若验签失败会抛出异常
     * @param token
     * @return
     */
    public static String verify(String token){
        return JWT.require(Algorithm.HMAC256(SIGNATURE))
                .build()
                .verify(token)
                .getClaim(USER_ID)
                .asString();
    }

}
