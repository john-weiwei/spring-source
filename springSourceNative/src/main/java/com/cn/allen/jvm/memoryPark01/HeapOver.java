package com.cn.allen.jvm.memoryPark01;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/5/26
 * @Description:
 * 堆溢出----
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 设置堆内存的最小 -Xms、最大值 -Xmx
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
