package com.cn.allen.redis;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangWeiWei
 * @date 2021/4/17 8:29
 * @description
 */
public class LimitService {

    private Logger logger = LoggerFactory.getLogger(LimitService.class);
    public Object limitAccess(String ip, int time, long numAccess) {

        String dataKey = "accessData:";
        String accessNumKey = "accessNum:";
        Jedis jedis = JedisUtils.getInstance();

//        String accessNumValue = jedis.get(accessNumKey);
//        if (StringUtils.isBlank(accessNumValue)) {
//            Transaction transaction = jedis.multi();
//            transaction.del(dataKey);
//            transaction.set(accessNumKey,"1");
//            transaction.expire(accessNumKey,time);
//            transaction.exec();
//        }
        String accessNumValue = jedis.get(accessNumKey);
        long accessNum = Long.parseLong(accessNumValue == null ? "0" : accessNumValue);
        if (accessNum >= numAccess) {
            return "Access number exceeded";
        }
        HashMap<String,String> accessData = new HashMap<>();
        accessData.put("ip",ip);
        accessData.put("time",String.valueOf(System.currentTimeMillis()));
        jedis.incr(accessNumKey);
        int num = Integer.parseInt(jedis.get(accessNumKey));
        if (num == 1) {
            jedis.expire(accessNumKey,time);
        }
        //保存访问记录
        if (!jedis.exists(dataKey)) {
            jedis.lpush(dataKey, JSON.toJSONString(accessData));
            jedis.expire(dataKey,time);
        } else {
            jedis.lpush(dataKey, JSON.toJSONString(accessData));

        }
        System.out.println("access successful time:{}"+num);
        return "ok";
    }

    public static void main(String[] args) {
        LimitService limitService = new LimitService();
        for (int i = 0; i < 20; i++) {
            limitService.limitAccess("127.0.0.1",60,10);
        }
    }

}
