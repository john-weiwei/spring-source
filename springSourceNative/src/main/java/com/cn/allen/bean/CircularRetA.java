package com.cn.allen.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:ZhangWeiWei
 * @Date:2021/1/5
 * @Description:
 */
//@Service
public class CircularRetA {

    public CircularRetA() {
        System.out.println("========CircularRetA()=====");
    }

    @Autowired
    private CircularRetB B;
}
