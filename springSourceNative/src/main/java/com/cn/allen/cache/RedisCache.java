package com.cn.allen.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;

import java.util.concurrent.Callable;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/5
 * @Description:
 */
public class RedisCache implements Cache {

    private RedisTemplate<String,Object> redisTemplate;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisCache() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    @Override
    public ValueWrapper get(Object key) {
        String strKey = key.toString();
        Object object = redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] key = strKey.getBytes();
                byte[] value = redisConnection.get(key);
                if (value == null) {
                    System.out.println("缓存不存在");
                    return null;
                }
                return SerializationUtils.deserialize(value);
            }
        });
        ValueWrapper valueWrapper = (object != null ? new SimpleValueWrapper(object) : null);
        System.out.println("从缓存中获取到的值："+(valueWrapper != null ? valueWrapper.get() : null));
        return valueWrapper;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        System.out.println("加入到缓存");
        System.out.println("缓存的key："+key);
        System.out.println("缓存的value："+value);
        final String strKey = key.toString();
        final Object objValue = value;
        final long liveTime = 86400;
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] key = strKey.getBytes();
                byte[] value = SerializationUtils.serialize(objValue);
                redisConnection.set(key,value);
                if (liveTime > 0) {
                    redisConnection.expire(key,liveTime);
                }
                return 1L;
            }
        });
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        return null;
    }

    @Override
    public void evict(Object key) {
        System.out.println("-----删除缓存-------");
        String strKey = key.toString();
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] key = strKey.getBytes();
                return redisConnection.del(key);
            }
        });
    }

    @Override
    public void clear() {
        System.out.println("-------清除缓存--------");
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.flushDb();
                return "OK";
            }
        });
    }
}
