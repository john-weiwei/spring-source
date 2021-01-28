package com.cn.allen.aopbean.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/13
 * @Description:
 */
public class JdkProxy implements InvocationHandler {

    People people;

    public JdkProxy(People people) {
        this.people = people;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object value = method.invoke(people,args);
        after();
        return value;
    }

    public void before() {
        System.out.println("方法调用前");
    }

    public void after() {
        System.out.println("方法调用后");
    }
}
