package com.chris.onlineSchool.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;
@Component
public class RedisUtils {
    @Resource
    private RedisTemplate redisTemplate;

    public  String getVerifyCode(String username, int count){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++){
            sb.append(random.nextInt(9));
        }
        String key = "verifyCode:" + username;
        redisTemplate.opsForValue().set(key, sb.toString(), 60, TimeUnit.SECONDS);
        return sb.toString();
    }
}
