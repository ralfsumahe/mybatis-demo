package com.lk.mybatis.config;

import com.lk.mybatis.pojo.UserCourseCollection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisCachConfig {
    @Bean
    public RedisTemplate<String, UserCourseCollection> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,UserCourseCollection> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setDefaultSerializer(RedisSerializer.string());
//        redisTemplate.setKeySerializer(RedisSerializer.string());
//        redisTemplate.setHashKeySerializer(RedisSerializer.string());
//        redisTemplate.setValueSerializer(RedisSerializer.json());
//        redisTemplate.setHashValueSerializer(RedisSerializer.json());
        return redisTemplate;
    }
}
