package com.cn.allen.aopbean.jdkproxy;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/13
 * @Description:
 */
public class Allen implements People{
    @Override
    public void eat() {
        System.out.println("吃饭长大的");
    }
}
