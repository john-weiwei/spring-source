package com.cn.allen.bean;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/14
 * @Description:
 */
public class PropertyClass {

    public String initMethod() {
        System.out.println("这是初始化方法");
        return "";
    }

    public void destroyMethod() {
        System.out.println("这是销毁方法");
    }
}
