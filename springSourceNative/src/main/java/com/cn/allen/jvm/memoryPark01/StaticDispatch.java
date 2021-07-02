package com.cn.allen.jvm.memoryPark01;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/22
 * @Description:
 * 方法静态分派
 * 所有依赖静态分派类型来定位方法执行版本的分派动作称为静态分派。
 * 静态分派的典型应用是方法重载。静态分派发生在编译阶段，确定静态
 * 分派的动作是由编译器来完成的
 */
public class StaticDispatch {
    static abstract class Human{
    }
    static class Man extends Human {
    }
    static class Woman extends Human {
    }
    public void sayHello(Human guy) {
        System.out.println("hello guy");
    }
    public void sayHello(Man man) {
        System.out.println("hello gentleman");
    }
    public void sayHello(Woman women) {
        System.out.println("hello woman");
    }
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);

//        实际类型变化
//        Human man = new Man();
//        man = new Woman();
        //静态类型变化
        sd.sayHello((Man) man);
        sd.sayHello((Woman) woman);
    }

}
