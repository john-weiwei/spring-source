package com.cn.allen.cache;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/5
 * @Description:
 */
//@Component
//@EnableCaching
public class CachingBean {


    @Bean
    public Cache redisCache(RedisTemplate<String,Object> redisTemplate){
        RedisCache redisCache = new RedisCache();
        redisCache.setName("redisCache");
        redisCache.setRedisTemplate(redisTemplate);
        return redisCache;
    }

    @Bean
    public CacheManager simpleCacheManager(@Qualifier("redisCache") RedisCache redisCache) {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<>();
        caches.add(redisCache);
        simpleCacheManager.setCaches(caches);
        return simpleCacheManager;
    }

}
