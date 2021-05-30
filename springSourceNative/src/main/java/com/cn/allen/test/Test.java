package com.cn.allen.test;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/5/21
 * @Description:
 */
public class Test {
    public String reverse(String originStr){
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1))+originStr.charAt(0);
    }

    public static void main(String[] args){
        String str = "abcde";
        Test t= new Test();
        String reStr = t.reverse(str);
        System.out.println(reStr);
    }

    public void outOfMemory() {
        AtomicInteger num = new AtomicInteger(1);
        LinkedList linkedList = new LinkedList();
        while (true) {
            System.out.println(num.getAndIncrement());
            Object obj = new Object();
            linkedList.add(obj);
        }
    }
}
