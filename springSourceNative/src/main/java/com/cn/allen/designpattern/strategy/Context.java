package com.cn.allen.designpattern.strategy;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/3/8
 * @Description:
 */
public class Context {
    private StrategyInter strategyInter;

    public void setStrategyInter(StrategyInter strategyInter) {
        this.strategyInter = strategyInter;
    }

    public void handler() {
        strategyInter.handlerContent();
    }
}
