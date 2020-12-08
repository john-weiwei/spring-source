package com.cn.my.test;

import com.cn.my.bean.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/8
 * @Description:
 */
public class MyTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student.getUserName());
    }
}
