package com.cn.allen.test;

import com.cn.allen.bean.ComponentScanBean;
import com.cn.allen.service.cache.CacheService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/5
 * @Description:
 */
public class CacheTest {

    private ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
    }

    @Test
    public void test1() {
        CacheService cacheService = applicationContext.getBean(CacheService.class);
        cacheService.queryData("XJ12");
    }

}
