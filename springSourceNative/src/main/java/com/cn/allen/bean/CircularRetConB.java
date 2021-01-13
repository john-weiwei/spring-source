package com.cn.allen.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/5
 * @Description:
 * 构造函数的循环依赖是无法解决的，因为beanA在构造函数实例化时，当前beanA没有存放到
 * 三级缓存中，并且在singletonsCurrentlyInDestruction容器中会存有一份，
 * 如果形参是引用类型，此时就调到了beanB的getBean操作；同理，beanB在执行
 * 构造函数实例化时，beanB也没有存放到三级缓存，就调用到它的形参beanA的getBean操作，
 * 又会往singletonsCurrentlyInDestruction容器中添加beanA，原先已经存放了beanA，
 * 通过看源码发现，重复存放同一个beanName会抛异常。所以通过构造函数的循环依赖是无法解决的
 */
//@Service
public class CircularRetConB {

    @Autowired
    public CircularRetConB(CircularRetConA A) {
        System.out.println("======CircularRetB()=====");
    }

}
