package com.cn.allen.jvm.memoryPark01;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/22
 * @Description:
 * 方法动态分派
 */
public class DynamicDispatch {
    static abstract class Human{
        abstract void sayHello();
    }
    static class Man extends Human {
        @Override
        void sayHello() {
            System.out.println("hello gentleman");
        }
    }
    static class Woman extends Human {
        @Override
        void sayHello() {
            System.out.println("hello woman");
        }
    }
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
    /**
     * hello gentleman
     * hello woman
     * hello woman
     */
}
