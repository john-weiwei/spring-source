package com.cn.allen.jvm.memoryPark01;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/5/26
 * @Description:
 * 栈溢出-----无限循环
 * -Xss256k
 * 设置栈内存容量
 */
public class StackOver {
    public static void main(String[] args) {
        stackTest();
    }
    public static void stackTest() {
        System.out.println("stack");
        stackTest();
    }
}
