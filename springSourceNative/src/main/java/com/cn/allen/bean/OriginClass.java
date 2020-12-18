package com.cn.allen.bean;

import java.util.List;

/**
 * @Author:ZhangWeiWei
 * @Date:2020/12/16
 * @Description:
 */
public class OriginClass {

    /**
     *
     * @param param
     */
    public void method(String param) {
        System.out.println("I am origin class"+param);
    }

    public void method(List param) {
        System.out.println("I am origin class"+param);
    }
}
