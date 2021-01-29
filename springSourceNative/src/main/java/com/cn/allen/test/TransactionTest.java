package com.cn.allen.test;

import com.cn.allen.bean.ComponentScanBean;
import com.cn.allen.pojo.ConsultConfigArea;
import com.cn.allen.service.area.AreaService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/29
 * @Description:
 */
public class TransactionTest {

    private ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
        System.out.println("执行前置增强");
    }

    @Test
    public void addAreaTest() {
        AreaService bean = applicationContext.getBean(AreaService.class);
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("XJ12");
        area.setAreaName("XJ12");
        area.setState("2");
        bean.addArea(area);
    }

    @Test
    public void test1() {
        AreaService bean = applicationContext.getBean(AreaService.class);
        Map param = new HashMap();
        param.put("areaCode","XJ14");
        bean.queryAreaFromDB(param);
    }

}
