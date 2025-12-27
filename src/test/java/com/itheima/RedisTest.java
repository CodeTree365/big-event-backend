package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * @author Shujie Liu
 * @project big-event
 * @date 2025/11/10
 */
@SpringBootTest // 如果在测试类上添加了这个注解，那么将来单元测试方法执行之前，会先初始化Spring容器
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        // 在Redis中存储一个键值对 StringRedisTemplate
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        ops.set("name", "小王");
        ops.set("id", "1", 15, TimeUnit.SECONDS);
    }

    public void testGet() {
        // 从Redis中获取一个键值对
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String name = ops.get("name");
    }
}