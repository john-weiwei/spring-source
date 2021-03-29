package com.cn.allen.designpattern.strategy;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/3/8
 * @Description:
 */
public class StrategyImpl extends OtherInfo implements StrategyInter {
    @Override
    public void handlerContent() {
        System.out.println("调用处理逻辑 "+ name + "-"+age);
    }
}
