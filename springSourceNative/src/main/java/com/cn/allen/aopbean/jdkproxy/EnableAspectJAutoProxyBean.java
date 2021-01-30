package com.cn.allen.aopbean.jdkproxy;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/11
 * @Description:
 * 采用注解的方式开启aop功能
 * 1、先扫描Service注解，再扫描Import注解
 */
@Service
@EnableAspectJAutoProxy(proxyTargetClass = false,exposeProxy = true)
// 等同于 <aop:aspectj-autoproxy/>
public class EnableAspectJAutoProxyBean {
}
