package com.cn.allen.test;


import com.cn.allen.bean.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/11/27
 * @Description:
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MyTest {

    @Autowired
    private ShowSexClass showSexClass;

    /**
     * spring 扫描注解的应用上下文
     */
    @Test
    public void test1() {
        //在单元测试中使用
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("com.cn.allen.bean");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.getUsername());
    }

    /**
     * 基于xml文件的上下文
     */
    @Test
    public void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.getUsername());
    }

    @Test
    public void test6() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Son student = (Son) applicationContext.getBean("son");
        System.out.println(student.getUsername());
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        PropertyClass student = (PropertyClass) applicationContext.getBean("propertyClass");
    }

    public void test4() {
        //内嵌的web上下文
    }

    @Test
    public void test5() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ShowSexClass showSexClass = (ShowSexClass) applicationContext.getBean("person");
        showSexClass.showSex();
    }


    @Test
    public void test7() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        OriginClass showSexClass = (OriginClass) applicationContext.getBean("originClass");
        showSexClass.method("xxx");
        showSexClass.method(new ArrayList());
    }
}
