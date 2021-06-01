package com.cn.allen.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

/**
 * @author ZhangWeiWei
 * @date 2021/4/17 8:25
 * @description
 */
public class JedisUtils {

    private static String host = "127.0.0.1";

    private static Logger logger = LoggerFactory.getLogger(JedisUtils.class);
    static class JedisInstance {
        public static Jedis jedis = new Jedis(host,6379);
    }

    public static Jedis getInstance() {
        return JedisInstance.jedis;
    }

    public static void main(String[] args) {
        Jedis jedis = JedisUtils.getInstance();
        jedis.set("admin","root");
        jedis.expire("admin",20);
        System.out.println(jedis.get("admin"));
        logger.info("hhhhhhhhh");
    }

}
