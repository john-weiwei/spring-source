package com.cn.allen.designpattern;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/2/25
 * @Description:
 */
public class Short implements Inter{
    private String flag = "short";
    @Override
    public void show(String value) {
        System.out.println("show shorts"+value);
    }

    @Override
    public boolean support(String value) {
        return flag.equalsIgnoreCase(value);
    }

    public Short(String flag) {
        this.flag = flag;
    }
}
