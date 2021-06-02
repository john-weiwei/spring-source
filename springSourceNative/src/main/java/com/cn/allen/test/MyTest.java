package com.cn.allen.test;


import com.cn.allen.bean.*;
import com.cn.allen.beanDefinition.BeanClass;
import com.cn.allen.factorybean.FactoryB;
import com.cn.allen.factorybean.FactoryBeanDemo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private MyAnnotation myAnnotation;

    private AtomicInteger count = new AtomicInteger(0);

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

    @Test
    public void test8() {
        applicationContext = new AnnotationConfigApplicationContext("com.cn.allen");
        BeanClass student = (BeanClass) applicationContext.getBean("beanClass");
        System.out.println(student.getUsername());
    }

    @Test
    public void test9() {
        System.out.println("custom annotation : "+myAnnotation.getName());
    }

    @Test
    public void test10() {
        FactoryB factoryB = (FactoryB) applicationContext.getBean("factoryBeanDemo");
        System.out.println(factoryB);
        //com.cn.allen.factorybean.FactoryB@e7edb54

        FactoryBeanDemo factoryBeanDemo = (FactoryBeanDemo) applicationContext.getBean("&factoryBeanDemo");
        System.out.println(factoryBeanDemo);
        //com.cn.allen.factorybean.FactoryBeanDemo@378542de
    }

    @Test
    public void test11(){
        DependsOnDemo dependsOn1 = (DependsOnDemo) applicationContext.getBean("dependsOn1");
        dependsOn1.dependsOn2();
    }

    @Test
    public void prototypeTest() {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(()->{
                if (finalI % 2 == 0 ) {
                    System.out.println(Thread.currentThread().getName() + "->" +applicationContext.getBean("prototypeBean"));
                    System.out.println(Thread.currentThread().getName() + "->" +applicationContext.getBean("prototypeBean"));
                } else {
                    System.out.println(Thread.currentThread().getName() + "->" +applicationContext.getBean("prototypeBean"));
                }
            }).start();
        }
    }

    @Test
    public void requestScope() {
        applicationContext.getBean("requestSessionBean");
    }

    @Test
    public void componentScanBeanTest() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
        System.out.println("扫描的方式实例化");
    }

    @Test
    public void test22() {
        String str = "abcde";
//        System.out.println(str.substring(1)+str.charAt(0));
//        String newStr1 = str.substring(1) + str.charAt(0);
//        System.out.println(newStr1);
//        String newStr2 = newStr1.substring(1) + newStr1.charAt(0);
//        System.out.println(newStr2);
//        String newStr3 = newStr2.substring(1) + newStr2.charAt(0);
//        System.out.println(newStr3);
//        String newStr4 = newStr3.substring(1) + newStr3.charAt(0);
//        System.out.println(newStr4);
//        String newStr5 = newStr4.substring(1) + newStr4.charAt(0);
//        System.out.println(newStr5+newStr5.charAt(0));

//        System.out.println(reverse(str));

        List list = getArrList();
        System.out.println(list);

    }

    private List getArrList() {
        return Collections.EMPTY_LIST;
    }

    private String getStrString() {
        return null;
    }

    private String reverse(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        System.out.println(str.substring(1) + str.charAt(0));
        System.out.println(count.getAndIncrement());
        return reverse(str.substring(1)) + str.charAt(0);

    }
}
