package com.cn.allen.jvm.memoryPark01;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/5/26
 * @Description:
 * 内存溢出----
 */
public class HeapOver {
    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(1);
        LinkedList linkedList = new LinkedList();
        while (true) {
            Object obj = new Object();
            linkedList.add(obj);
            System.out.println(num.getAndIncrement());
        }
    }
}
