package com.cn.allen.targetSource;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/19
 * @Description:
 */
@Service
public class GirlMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("拦截漂亮美眉");
        return invocation.proceed();
    }
}
