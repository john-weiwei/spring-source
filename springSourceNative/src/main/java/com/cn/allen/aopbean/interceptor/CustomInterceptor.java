package com.cn.allen.aopbean.interceptor;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/18
 * @Description:
 */
@Component
public class CustomInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("=====全局拦截======");
        return invocation.proceed();
    }
}
