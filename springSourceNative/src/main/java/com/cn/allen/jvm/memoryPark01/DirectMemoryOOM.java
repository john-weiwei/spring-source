package com.cn.allen.jvm.memoryPark01;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/18
 * @Description:
 */
public class DirectMemoryOOM {
    private static int _1M = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        while (true) {
            unsafe.allocateMemory(_1M);
        }

    }
}
