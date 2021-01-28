package com.cn.allen.aopbean.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/11
 * @Description:
 */
@Component
@Aspect
public class AspectAnnotation {

    //接入点
    @Pointcut("execution(public * com.cn.allen.service.*.*(..))")
    public void pic1(){
    }

    //这个方法就是增强advice
    @Around("pic1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("执行前置通知");
        String result = (String) joinPoint.proceed();
        String he = "增强advice";
        System.out.println("执行后置通知");
        return result;
    }

    @Before("pic1()")
    public void before1(JoinPoint joinPoint) {
        System.out.println("前置通知");
    }
}
