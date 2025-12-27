package com.itheima;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shujie Liu
 * @project big-event
 * @date 2025/10/29
 */
public class JwtTest {

    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Shujie");
        // 生成jwt的代码
        String token = JWT.create()
                .withClaim("user", claims) // 添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 设置过期时间
                .sign(Algorithm.HMAC256("itheima")); // 指定算法，配置使用

        System.out.println(token);
    }

    @Test
    public void testParse() {
        // 定义字符串，模拟用户传递过来的token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IlNodWppZSJ9LCJleHAiOjE3NjE3NzIxMzh9" +
                ".d1sqLoKHsPaio2qiO2gy0jVO_f0P93clpyXWQn9zb4Q";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();

        try {
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            Map<String, Claim> claims = decodedJWT.getClaims();
            System.out.println(claims.get("user"));
        } catch (TokenExpiredException e) {
            System.out.println("Token已过期: " + e.getMessage());
            // 在实际应用中，这里应该返回适当的HTTP状态码，如401
        } catch (Exception e) {
            System.out.println("Token验证失败: " + e.getMessage());
            // 在实际应用中，这里应该返回适当的HTTP状态码，如401
        }

        // 如果篡改了头部和载荷部分的数据，那么验证失败
        // 如果秘钥改了，验证失败
    }
}