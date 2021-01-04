package com.net.seckill.service.impl;

import com.net.seckill.service.TestInterface;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author 10014994
 * @since 2020/11/14
 */
@Service
public class Test2 implements TestInterface {

    @Override
    public String doThings() {
        return "test2";
    }

    @Cacheable(value = "accessToken" , key = "# currentTimeMillis/5/1000")
    public String getCache(long currentTimeMillis) {
        String accessToken = String.valueOf(new SecureRandom().nextInt(10));
        return accessToken;
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<Cache>();
        caches.add(new ConcurrentMapCache("accessToken"));
        cacheManager.setCaches(caches);
        return cacheManager;
    }

}
