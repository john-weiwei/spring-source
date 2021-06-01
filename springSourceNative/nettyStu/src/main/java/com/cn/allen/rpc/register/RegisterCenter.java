package com.cn.allen.rpc.register;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/1
 * @Description:
 */
public class RegisterCenter {

    private static ConcurrentHashMap<String, Set<RegisterServiceVo>> registerMap = new ConcurrentHashMap<>();

    private int port;

    public RegisterCenter(int port) {
        this.port = port;
    }

    //考虑到有多个提供者同时注册服务，加锁
    public static synchronized void registerService(String serviceName, String host,int port) {
        Set<RegisterServiceVo> serviceVoSet = registerMap.get(serviceName);
        if (Objects.equals(null,serviceVoSet)) {
            serviceVoSet = new HashSet<>();
            registerMap.put(serviceName,serviceVoSet);
        }
        //将新服务添加到集合
        serviceVoSet.add(new RegisterServiceVo(host,port));
        System.out.println("服务已注册["+serviceName+"]，" +
                "地址["+host+"]，端口["+port+"]");
    }

    //取出服务提供者
    public static Set<RegisterServiceVo> getService(String serviceName) {
        return registerMap.get(serviceName);
    }

}
