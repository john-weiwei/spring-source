package com.cn.allen.designpattern;

import java.util.ServiceLoader;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/25
 * @Description:
 */
public class Store {
    public static void main(String[] args) {
        String flag = "short";
        ServiceLoader<Inter> serviceLoader = ServiceLoader.load(Inter.class);
        for (Inter inter : serviceLoader) {
            if (inter.support(flag)) {
                inter.show();
            }
        }
    }
}
