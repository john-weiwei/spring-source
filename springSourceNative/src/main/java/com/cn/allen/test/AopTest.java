package com.cn.allen.test;

import com.cn.allen.bean.ComponentScanBean;
import com.cn.allen.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/11
 * @Description:
 */
public class AopTest {

    private ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
    }

    @Test
    public void test1() {
        UserService userService = applicationContext.getBean(UserService.class);
        userService.queryUser("allen");
    }

    @Test
    public void costomInterceptorTest() {

        UserService userService = applicationContext.getBean(UserService.class);
        AnnotationAwareAspectJAutoProxyCreator bean = applicationContext.getBean(AnnotationAwareAspectJAutoProxyCreator.class);
        bean.setInterceptorNames("girlMethodInterceptor");

        userService.queryUser("a");
    }
}
