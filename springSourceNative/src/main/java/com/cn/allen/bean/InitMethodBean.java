package com.cn.allen.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/5
 * @Description:
 * 如果需要在一个类实例化之后去做一些其他事情，就可以实现InitializingBean接口来完成
 */
public class InitMethodBean implements InitializingBean, BeanNameAware {

    /**
     * 属性设置完成后调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=======InitMethodBean类实例化完成以后会调到======");
    }

    /**
     * bean完全实例化之后调用
     */
    public void initMethod() {
        System.out.println("=======InitMethodBean.initMethod=====");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("=======InitMethodBean.postConstruct======");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("======beanName.setBeanName====:"+name);
    }
}
