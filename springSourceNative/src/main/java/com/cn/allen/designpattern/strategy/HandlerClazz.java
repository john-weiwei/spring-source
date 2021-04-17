package com.cn.allen.designpattern.strategy;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/3/8
 * @Description:
 */
public class HandlerClazz {
    public static void main(String[] args) {
        StrategyInter strategy = new StrategyImpl();
        OtherInfo otherInfo = (OtherInfo) strategy;
        otherInfo.setAge(23);
        otherInfo.setName("lisi");


        Context context = new Context();
        context.setStrategyInter(strategy);
        context.handler();

        testMain();
    }


    public static void testMain() {
        if (testBoolean()) {
            System.out.println("没有继续往下执行");
        }
        System.out.println("执行完成");
    }

    public static boolean testBoolean() {
        return true;
    }

}
