package com.cn.allen.jvm.memoryPark01;

import java.util.concurrent.TimeUnit;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/6/18
 * @Description:
 * 主要演示两点
 *  1、对象被GC时可以自我拯救
 *  2、自救的机会只有一次，因为任何一个对象的finalize()方法都只会被系统调用一次
 *  finalize method executed!
 *  i am still alive
 *  i am dead .....
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC save_hook = null;
    public void isAlive() {
        System.out.println("i am still alive");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.save_hook = this;
    }
    public static void main(String[] args) throws InterruptedException {
        save_hook = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        save_hook = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        if (save_hook != null) {
            save_hook.isAlive();
        } else {
            System.out.println("i am dead .....");
        }
        //这次拯救失败
        save_hook = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        if (save_hook != null) {
            save_hook.isAlive();
        } else {
            System.out.println("i am dead .....");
        }
    }
}
