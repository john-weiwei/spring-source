package com.cn.allen.test;


import com.cn.allen.bean.PropertyClass;
import com.cn.allen.bean.Son;
import com.cn.allen.bean.Student;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/11/27
 * @Description:
 */
public class MyTest {

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


    }
}
