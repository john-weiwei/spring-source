package com.cn.allen.aopbean.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/13
 * @Description:
 */
public class ProxyTest {
    public static void main(String[] args) {
        People people = (People)Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class<?>[]{People.class},new JdkProxy(new Allen()));
        people.eat();
    }
}
