package com.cn.allen.jvm.memoryPark01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/18
 * @Description:
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        int num = 0;
        while (true) {
            lists.add(String.valueOf(num++).intern());
        }
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//        String str2 = new StringBuilder("py").append("thon").toString();
//        System.out.println(str2.intern() == str2);
        /**
         * jdk1.7之后的intern()方法实现不会再复制实例，只是在常量池中记录
         * 首次出现（首次出现是指在对象没有创建之前，常量池中没有这个值）的实例引用，因此intern()方法返回的引用和由StringBuilder
         * 创建的字符串实例是同一个。
         */

    }
}
