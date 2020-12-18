package com.cn.allen.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/16
 * @Description:
 */
public class ReplaceClass implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("I am replace class----->reimplement");
        return null;
    }
}
