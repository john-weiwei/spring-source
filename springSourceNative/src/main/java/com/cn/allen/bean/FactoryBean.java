package com.cn.allen.bean;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/14
 * @Description:
 */
public class FactoryBean {

    public Object factoryMethod(/*String id,List param*/) {
        System.out.println("-------factoryMethod--------");
        return new PropertyClass();
    }
}
