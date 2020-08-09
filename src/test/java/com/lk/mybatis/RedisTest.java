package com.lk.mybatis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    public RedisTemplate redisTemplate;
    @Autowired
    public StringRedisTemplate stringRedisTemplate;
    @Test
    public void test(){
        Set<String> keys = stringRedisTemplate.keys("collection::1_*");
        Assert.assertEquals(0, keys.size());
    }

}
