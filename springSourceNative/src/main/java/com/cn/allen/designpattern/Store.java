package com.cn.allen.designpattern;

import sun.reflect.Reflection;

import java.util.ServiceLoader;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/25
 * @Description:
 */
public class Store {
    public static void main(String[] args) {
        String flag = "short";
        String value = "short";
        ServiceLoader<Inter> serviceLoader = ServiceLoader.load(Inter.class);
        for (Inter inter : serviceLoader) {
            if (inter.support(flag)) {
                inter.show(value);
            }
        }
    }

    private static void test() {

        Reflection ref = new Reflection();

    }

}

