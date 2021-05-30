package com.cn.allen.jedis;

import redis.clients.jedis.Jedis;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/4/23
 * @Description:
 */
public class JedisUtil {
    private static String host = "192.168.3.10";
    static class JedisInstance{
        private static Jedis jedis = new Jedis(host);
    }

    public static Jedis getInstance() {
        return JedisInstance.jedis;
    }

    public static void main(String[] args) {
        Jedis jedis = getInstance();
        jedis.set("name","zhangsan");
        System.out.println(jedis.get("name"));
    }
}
