package com.cn.allen.jvm.memoryPark01;

import java.io.Serializable;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/22
 * @Description:
 * 重载匹配优先级
 * 可变长参数的重载优先级最低。
 * 编译期间选择静态分派目标的过程是java实现方法重载的本质
 * 按照char>int>long>float>double的顺序转型进行匹配，
 * 但不会匹配到byte和short类型的重 载，因为char到byte或short的转型是不安全的
 */
public class Overload {
    //编号代表优先级，编号越小，优先级越高
    // 1
    public static void sayHello(char arg) {
        System.out.println("hello char");
    }
    // 2
    public static void sayHello(int arg) {
        System.out.println("hello int");
    }
    // 3
    public static void sayHello(long arg) {
        System.out.println("hello long");
    }
    // 4
    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }
    // 5
    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }
    // 6
    public static void sayHello(Object arg) {
        System.out.println("hello object");
    }
    // 可变长参数的重载优先级最低
    // 7
    public static void sayHello(char... arg) {
        System.out.println("hello char...");
    }
    // 8
    public static void sayHello(int... arg) {
        System.out.println("hello char...");
    }
    public static void main(String[] args) {
        sayHello('a');
    }
}
