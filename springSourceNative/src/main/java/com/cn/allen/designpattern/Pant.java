package com.cn.allen.designpattern;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/25
 * @Description:
 */
public class Pant implements Inter {
    private String flag = "pant";
    @Override
    public void show() {
        System.out.println("show pants");
    }

    @Override
    public boolean support(String value) {
        return flag.equalsIgnoreCase(value);
    }
}
